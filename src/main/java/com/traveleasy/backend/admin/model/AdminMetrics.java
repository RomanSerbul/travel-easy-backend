package com.traveleasy.backend.admin.model;

public record AdminMetrics(
        MetricItem activeBookings,
        MetricItem averagePrice,
        MetricItem cancellationRate,
        MetricItem totalRevenue
) {
    public record MetricItem(
            String label,
            String value,
            String change,
            boolean positive
    ) {
    }
}
