package com.traveleasy.backend.catalog.api;

import com.traveleasy.backend.common.dto.ApiResponse;
import com.traveleasy.backend.notifications.model.NotificationPayload;
import com.traveleasy.backend.notifications.service.NotificationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final NotificationService notificationService;

    public ContactController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> submitContactForm(@Valid @RequestBody ContactRequest request) {
        log.info("📩 Нове повідомлення з форми зворотного зв'язку від: {} ({})", request.name(), request.email());

        String telegramMessage = """
                📩 Повідомлення з сайту!
                
                👤 %s
                📧 %s
                📱 %s
                📋 %s
                
                💬 %s
                """.formatted(
                request.name(),
                request.email(),
                request.phone() != null && !request.phone().isBlank() ? request.phone() : "Не вказано",
                request.subject() != null && !request.subject().isBlank() ? request.subject() : "Без теми",
                request.message()
        );

        var payload = new NotificationPayload("contact-form", Map.of(
                "name", request.name(),
                "email", request.email(),
                "phone", request.phone() != null ? request.phone() : "",
                "subject", request.subject() != null && !request.subject().isBlank() ? request.subject() : "Повідомлення з сайту",
                "message", request.message(),
                "telegramMessage", telegramMessage
        ));

        notificationService.sendToAll(payload);

        return ResponseEntity.ok(ApiResponse.of("Повідомлення надіслано успішно"));
    }
}
