package com.traveleasy.backend.orders.model;

import java.time.Instant;
import java.util.UUID;

public record StartWizardResponse(UUID sessionId, Instant expiresAt) {
    public static StartWizardResponse from(BookingWizardSession session) {
        return new StartWizardResponse(session.sessionId(), session.expiresAt());
    }
}
