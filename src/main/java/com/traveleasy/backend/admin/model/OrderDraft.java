package com.traveleasy.backend.admin.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public record OrderDraft(
        @NotBlank String proposalId,
        @NotBlank String customerName,
        @Email @NotBlank String customerEmail,
        @NotBlank String customerPhone,
        @NotNull LocalDate startDate,
        @Positive int nights,
        @Positive int guests,
        List<String> addOns,
        String notes
) {
}
