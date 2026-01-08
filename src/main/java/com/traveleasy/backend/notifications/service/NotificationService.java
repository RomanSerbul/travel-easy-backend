package com.traveleasy.backend.notifications.service;

import com.traveleasy.backend.notifications.model.NotificationPayload;

public interface NotificationService {
    void sendToAll(NotificationPayload payload);
}
