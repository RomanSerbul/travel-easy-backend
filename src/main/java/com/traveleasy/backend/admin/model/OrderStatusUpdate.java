package com.traveleasy.backend.admin.model;

import jakarta.validation.constraints.NotBlank;

public record OrderStatusUpdate(
        @NotBlank(message = "Status is required")
        String status
) {
}
