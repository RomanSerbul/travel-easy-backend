package com.traveleasy.backend.notifications.channel;

import com.traveleasy.backend.notifications.model.NotificationPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.HashMap;

@Component
public class EmailNotificationChannel implements NotificationChannel {

    private static final Logger log = LoggerFactory.getLogger(EmailNotificationChannel.class);

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Value("${app.notifications.email.from:noreply@traveleasy.com}")
    private String fromEmail;

    @Value("${app.notifications.email.manager:}")
    private String managerEmail;

    public EmailNotificationChannel(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
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
        var message = mailSender.createMimeMessage();
        try {
            var helper = new MimeMessageHelper(message, "UTF-8");
            helper.setFrom(fromEmail);
            helper.setTo((String) payload.variables().getOrDefault("email", "test@example.com"));
            helper.setSubject((String) payload.variables().getOrDefault("subject", "Travel Easy – Підтвердження бронювання"));

            var context = new Context();
            context.setVariables(payload.variables());
            helper.setText(templateEngine.process(payload.template(), context), true);

            mailSender.send(message);
            log.info("Customer confirmation email sent to {}", payload.variables().get("email"));
        } catch (Exception ex) {
            log.warn("Failed to send customer email notification: {}", ex.getMessage());
        }
    }

    private void sendManagerEmail(NotificationPayload payload) {
        var message = mailSender.createMimeMessage();
        try {
            var helper = new MimeMessageHelper(message, "UTF-8");
            helper.setFrom(fromEmail);
            helper.setTo(managerEmail);
            helper.setSubject("🔔 Нове замовлення #" + payload.variables().getOrDefault("orderId", "N/A"));

            var vars = new HashMap<>(payload.variables());
            vars.put("createdAt", LocalDateTime.now());
            vars.put("customerEmail", payload.variables().get("email"));
            vars.put("customerPhone", payload.variables().getOrDefault("phone", "Не вказано"));

            var context = new Context();
            context.setVariables(vars);
            helper.setText(templateEngine.process("manager-notification", context), true);

            mailSender.send(message);
            log.info("Manager notification email sent to {}", managerEmail);
        } catch (Exception ex) {
            log.warn("Failed to send manager email notification: {}", ex.getMessage());
        }
    }
}
