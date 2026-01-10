package com.traveleasy.backend.admin.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ProposalDraft(
        @NotBlank String title,
        @NotBlank String city,
        @NotBlank String country,
        @Positive int durationDays,
        @NotNull BigDecimal priceFrom,
        List<String> tags,
        String heroImageUrl,
        String headline,
        Boolean hot,
        LocalDate departureDate,
        LocalDate returnDate,
        String description,
        String includes,
        String exclusions,
        String policy,
        List<String> images,
        Integer minGuests,
        Integer maxGuests,
        String programDetails,
        String difficultyLevel,
        String targetAudience,
        List<String> attractions,
        List<String> activities,
        List<String> highlights,
        String departureLocations
) {
}
