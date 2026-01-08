package com.traveleasy.backend.orders.model;

import jakarta.validation.constraints.NotBlank;

public record StartWizardRequest(@NotBlank String proposalId) {
}
