package com.traveleasy.backend.notifications.channel;

import com.traveleasy.backend.notifications.model.NotificationPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class TelegramNotificationChannel implements NotificationChannel {

    private static final Logger log = LoggerFactory.getLogger(TelegramNotificationChannel.class);

    private final WebClient webClient;
    private final String botToken;
    private final String chatId;

    public TelegramNotificationChannel(@Value("${app.notifications.telegram.bot-token:}") String botToken,
                                       @Value("${app.notifications.telegram.chat-id:}") String chatId,
                                       WebClient.Builder webClientBuilder) {
        this.botToken = botToken;
        this.chatId = chatId;
        this.webClient = webClientBuilder.baseUrl("https://api.telegram.org").build();
    }

    @Override
    public String channelName() {
        return "telegram";
    }

    @Override
    public void send(NotificationPayload payload) {
        if (botToken == null || botToken.isBlank() || chatId == null || chatId.isBlank()) {
            log.debug("Telegram credentials not configured, skipping send");
            return;
        }
        var text = (String) payload.variables().getOrDefault("message", "Travel Easy: нове бронювання");
        webClient.post()
                .uri("/bot" + botToken + "/sendMessage")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{" +
                        "\"chat_id\":\"" + chatId + "\"," +
                        "\"text\":\"" + text.replace("\"", "'") + "\"}")
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(error -> log.warn("Telegram send failed", error))
                .subscribe(response -> log.debug("Telegram response: {}", response));
    }
}
