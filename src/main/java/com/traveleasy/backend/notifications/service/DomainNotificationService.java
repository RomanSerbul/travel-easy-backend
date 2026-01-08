package com.traveleasy.backend.notifications.service;

import com.traveleasy.backend.notifications.channel.NotificationChannel;
import com.traveleasy.backend.notifications.model.NotificationPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainNotificationService implements NotificationService {

    private static final Logger log = LoggerFactory.getLogger(DomainNotificationService.class);

    private final List<NotificationChannel> channels;
    private final ApplicationEventPublisher eventPublisher;

    public DomainNotificationService(List<NotificationChannel> channels, ApplicationEventPublisher eventPublisher) {
        this.channels = channels;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void sendToAll(NotificationPayload payload) {
        channels.forEach(channel -> {
            log.debug("Dispatching {} notification", channel.channelName());
            channel.send(payload);
        });
        eventPublisher.publishEvent(payload);
    }
}
