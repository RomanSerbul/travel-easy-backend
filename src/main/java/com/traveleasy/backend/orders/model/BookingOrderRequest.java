package com.traveleasy.backend.orders.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public record BookingOrderRequest(
        @NotBlank(message = "proposalId is required") String proposalId,
        String tourTitle,
        @NotBlank(message = "customerName is required") String customerName,
        @Email(message = "Некоректна email адреса") String customerEmail,
        @NotBlank(message = "customerPhone is required") String customerPhone,
        @NotNull LocalDate startDate,
        @Positive int nights,
        @Positive int guests,
        List<String> addOns,
        String notes
) {
}
