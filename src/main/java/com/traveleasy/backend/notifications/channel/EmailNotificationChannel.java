package com.traveleasy.backend.notifications.channel;

import com.traveleasy.backend.notifications.model.NotificationPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class EmailNotificationChannel implements NotificationChannel {

    private static final Logger log = LoggerFactory.getLogger(EmailNotificationChannel.class);

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public EmailNotificationChannel(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public String channelName() {
        return "email";
    }

    @Override
    public void send(NotificationPayload payload) {
        // TODO replace with persisted email routing once customer context is available
        var message = mailSender.createMimeMessage();
        try {
            var helper = new MimeMessageHelper(message, "UTF-8");
            helper.setTo((String) payload.variables().getOrDefault("email", "test@example.com"));
            helper.setSubject((String) payload.variables().getOrDefault("subject", "Travel Easy"));
            var context = new Context();
            context.setVariables(payload.variables());
            helper.setText(templateEngine.process(payload.template(), context), true);
            mailSender.send(message);
        } catch (Exception ex) {
            log.warn("Failed to send email notification", ex);
        }
    }
}
