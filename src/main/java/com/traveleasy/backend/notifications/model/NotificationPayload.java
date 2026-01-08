package com.traveleasy.backend.notifications.model;

import java.util.Map;

public record NotificationPayload(
        String template,
        Map<String, Object> variables
) {
}
