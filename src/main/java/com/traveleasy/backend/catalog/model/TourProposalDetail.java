package com.traveleasy.backend.catalog.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record TourProposalDetail(
        String id,
        String title,
        String tagline,
        String city,
        String country,
        int durationDays,
        BigDecimal priceFrom,
        List<String> tags,
        String heroImageUrl,
        boolean hot,
        String description,
        List<String> includes,
        List<String> exclusions,
        String policy,
        LocalDate departureDate,
        LocalDate returnDate,
        List<String> images,
        int minGuests,
        int maxGuests
) {
}
