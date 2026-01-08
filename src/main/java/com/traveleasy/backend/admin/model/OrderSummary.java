package com.traveleasy.backend.admin.model;

import java.time.LocalDate;
import java.util.UUID;

public record OrderSummary(
        UUID id,
        String proposalId,
        String proposalTitle,
        String customerName,
        String customerEmail,
        String customerPhone,
        LocalDate startDate,
        int nights,
        int guests,
        String status,
        String createdAt
) {
}
