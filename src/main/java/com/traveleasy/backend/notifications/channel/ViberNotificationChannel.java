package com.traveleasy.backend.notifications.channel;

import com.traveleasy.backend.notifications.model.NotificationPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ViberNotificationChannel implements NotificationChannel {

    private static final Logger log = LoggerFactory.getLogger(ViberNotificationChannel.class);

    private final WebClient webClient;
    private final String authToken;

    public ViberNotificationChannel(@Value("${app.notifications.viber.auth-token:}") String authToken,
                                     WebClient.Builder webClientBuilder) {
        this.authToken = authToken;
        this.webClient = webClientBuilder.baseUrl("https://chatapi.viber.com/pa").build();
    }

    @Override
    public String channelName() {
        return "viber";
    }

    @Override
    public void send(NotificationPayload payload) {
        if (authToken == null || authToken.isBlank()) {
            log.debug("Viber auth token not configured, skipping send");
            return;
        }
        var text = (String) payload.variables().getOrDefault("message", "Travel Easy: нове бронювання");
        var receiver = (String) payload.variables().get("viberReceiver");
        if (receiver == null) {
            log.debug("Viber receiver not provided, skipping send");
            return;
        }

        webClient.post()
                .uri("/send_message")
                .header("X-Viber-Auth-Token", authToken)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{" +
                        "\"receiver\":\"" + receiver + "\"," +
                        "\"type\":\"text\"," +
                        "\"text\":\"" + text.replace("\"", "'") + "\"}")
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(error -> log.warn("Viber send failed", error))
                .subscribe(response -> log.debug("Viber response: {}", response));
    }
}
