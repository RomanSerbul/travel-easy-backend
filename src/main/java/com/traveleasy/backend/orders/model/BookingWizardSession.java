package com.traveleasy.backend.orders.model;

import java.time.Instant;
import java.util.UUID;

public record BookingWizardSession(
        UUID sessionId,
        String proposalId,
        Instant expiresAt
) {
    public static BookingWizardSession start(String proposalId, Instant expiresAt) {
        return new BookingWizardSession(UUID.randomUUID(), proposalId, expiresAt);
    }
}
