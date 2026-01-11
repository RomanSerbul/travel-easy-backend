package com.traveleasy.backend.orders.model;

import java.time.Instant;
import java.util.UUID;

public record BookingOrderResponse(
        UUID orderId,
        Long orderNumber,
        String status,
        Instant createdAt
) {
}
