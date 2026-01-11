package com.traveleasy.backend.notifications.channel;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.traveleasy.backend.notifications.model.NotificationPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.HashMap;

@Component
public class EmailNotificationChannel implements NotificationChannel {

    private static final Logger log = LoggerFactory.getLogger(EmailNotificationChannel.class);

    private final Resend resend;
    private final TemplateEngine templateEngine;

    @Value("${app.notifications.email.from:romanserbul@gmail.com}")
    private String fromEmail;

    @Value("${app.notifications.email.manager:}")
    private String managerEmail;

    @Value("${app.notifications.email.verified-domain:false}")
    private boolean hasVerifiedDomain;

    public EmailNotificationChannel(
            @Value("${app.notifications.email.resend-api-key:}") String resendApiKey,
            TemplateEngine templateEngine) {
        this.resend = new Resend(resendApiKey);
        this.templateEngine = templateEngine;
    }

    @Override
    public String channelName() {
        return "email";
    }

    @Override
    @Async
    public void send(NotificationPayload payload) {
        // Send confirmation to customer
        sendCustomerEmail(payload);

        // Send notification to manager
        if (managerEmail != null && !managerEmail.isBlank()) {
            sendManagerEmail(payload);
        }
    }

    private void sendCustomerEmail(NotificationPayload payload) {
        try {
            String toEmail = (String) payload.variables().getOrDefault("email", "test@example.com");
            
            // Without verified domain, Resend only allows sending to owner's email
            if (!hasVerifiedDomain && !toEmail.equalsIgnoreCase(managerEmail)) {
                log.info("Skipping customer email to {} - no verified domain. Only manager ({}) will receive notification.", 
                        toEmail, managerEmail);
                return;
            }
            
            String subject = (String) payload.variables().getOrDefault("subject", "Travel Easy – Підтвердження бронювання");

            var context = new Context();
            context.setVariables(payload.variables());
            String htmlContent = templateEngine.process(payload.template(), context);

            CreateEmailOptions params = CreateEmailOptions.builder()
                    .from("Travel Easy <onboarding@resend.dev>")
                    .to(toEmail)
                    .subject(subject)
                    .html(htmlContent)
                    .build();

            resend.emails().send(params);
            log.info("Customer confirmation email sent to {} via Resend", toEmail);
        } catch (ResendException ex) {
            log.warn("Failed to send customer email via Resend: {}", ex.getMessage());
        }
    }

    private void sendManagerEmail(NotificationPayload payload) {
        try {
            var vars = new HashMap<>(payload.variables());
            vars.put("createdAt", LocalDateTime.now());
            vars.put("customerEmail", payload.variables().get("email"));
            vars.put("customerPhone", payload.variables().getOrDefault("phone", "Не вказано"));

            var context = new Context();
            context.setVariables(vars);
            String htmlContent = templateEngine.process("manager-notification", context);

            CreateEmailOptions params = CreateEmailOptions.builder()
                    .from("Travel Easy <onboarding@resend.dev>")
                    .to(managerEmail)
                    .subject("🔔 Нове замовлення #" + payload.variables().getOrDefault("orderId", "N/A"))
                    .html(htmlContent)
                    .build();

            resend.emails().send(params);
            log.info("Manager notification email sent to {} via Resend", managerEmail);
        } catch (ResendException ex) {
            log.warn("Failed to send manager email via Resend: {}", ex.getMessage());
        }
    }
}
