package com.traveleasy.backend.catalog.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactRequest(
        @NotBlank(message = "Ім'я обов'язкове")
        String name,

        @NotBlank(message = "Email обов'язковий")
        @Email(message = "Невірний формат email")
        String email,

        String phone,

        String subject,

        @NotBlank(message = "Повідомлення обов'язкове")
        @Size(max = 5000, message = "Повідомлення не може бути довшим за 5000 символів")
        String message
) {
}
