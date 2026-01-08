package com.traveleasy.backend.catalog.model;

import com.traveleasy.backend.catalog.domain.ProposalStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record TourProposalSummary(
        String id,
        String slug,
        String title,
        String tagline,
        String headline,
        String city,
        String country,
        int durationDays,
        BigDecimal priceFrom,
        List<String> tags,
        String heroImageUrl,
        boolean hot,
        ProposalStatus status,
        LocalDate departureDate,
        LocalDate returnDate
) {
}
