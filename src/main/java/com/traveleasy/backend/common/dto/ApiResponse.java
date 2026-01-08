package com.traveleasy.backend.common.dto;

import java.time.Instant;

public record ApiResponse<T>(Instant timestamp, T data) {
    public static <T> ApiResponse<T> of(T data) {
        return new ApiResponse<>(Instant.now(), data);
    }
}
