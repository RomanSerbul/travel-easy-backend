package com.traveleasy.backend.media.dto;

import java.time.Instant;

public record MediaItemDto(
        String id,
        String url,
        String fileName,
        Instant uploadedAt,
        Long size,
        String tourSlug,
        String tourTitle
) {
}
