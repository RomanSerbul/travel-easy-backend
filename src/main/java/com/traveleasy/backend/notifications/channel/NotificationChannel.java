package com.traveleasy.backend.notifications.channel;

import com.traveleasy.backend.notifications.model.NotificationPayload;

public interface NotificationChannel {
    String channelName();

    void send(NotificationPayload payload);
}
