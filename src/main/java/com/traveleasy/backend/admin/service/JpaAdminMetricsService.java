package com.traveleasy.backend.admin.service;

import com.traveleasy.backend.admin.model.AdminMetrics;
import com.traveleasy.backend.orders.domain.BookingOrder;
import com.traveleasy.backend.orders.repository.BookingOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class JpaAdminMetricsService implements AdminMetricsService {

    private final BookingOrderRepository bookingOrderRepository;
    private final DecimalFormat decimalFormat = new DecimalFormat("#.#");

    public JpaAdminMetricsService(BookingOrderRepository bookingOrderRepository) {
        this.bookingOrderRepository = bookingOrderRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public AdminMetrics calculateMetrics() {
        var allOrders = bookingOrderRepository.findAll();
        var now = LocalDateTime.now();
        var lastMonth = now.minus(30, ChronoUnit.DAYS);

        // Active bookings (CONFIRMED status)
        long activeBookings = allOrders.stream()
                .filter(o -> o.getStatus() == BookingOrder.BookingStatus.CONFIRMED)
                .count();

        long activeBookingsLastMonth = allOrders.stream()
                .filter(o -> o.getStatus() == BookingOrder.BookingStatus.CONFIRMED)
                .filter(o -> o.getCreatedAt().isBefore(lastMonth.toInstant(java.time.ZoneOffset.UTC)))
                .count();

        String activeBookingsChange = calculatePercentageChange(activeBookingsLastMonth, activeBookings);
        boolean activeBookingsPositive = activeBookings >= activeBookingsLastMonth;

        // Average check (mock calculation based on nights * guests * base rate)
        double baseRatePerNight = 50.0; // Base rate per person per night
        double totalRevenue = allOrders.stream()
                .filter(o -> o.getStatus() == BookingOrder.BookingStatus.CONFIRMED)
                .mapToDouble(o -> o.getNights() * o.getGuests() * baseRatePerNight)
                .sum();

        double averageCheck = activeBookings > 0 ? totalRevenue / activeBookings : 0;

        // For change calculation, we'll compare with last month's average
        double lastMonthRevenue = allOrders.stream()
                .filter(o -> o.getStatus() == BookingOrder.BookingStatus.CONFIRMED)
                .filter(o -> o.getCreatedAt().isBefore(lastMonth.toInstant(java.time.ZoneOffset.UTC)))
                .mapToDouble(o -> o.getNights() * o.getGuests() * baseRatePerNight)
                .sum();

        double lastMonthAverage = activeBookingsLastMonth > 0 ? lastMonthRevenue / activeBookingsLastMonth : 0;
        String averageCheckChange = calculatePercentageChange(lastMonthAverage, averageCheck);
        boolean averageCheckPositive = averageCheck >= lastMonthAverage;

        // Cancellation rate
        long totalOrders = allOrders.size();
        long cancelledOrders = allOrders.stream()
                .filter(o -> o.getStatus() == BookingOrder.BookingStatus.CANCELLED)
                .count();

        double cancellationRate = totalOrders > 0 ? (double) cancelledOrders / totalOrders * 100 : 0;

        long totalOrdersLastMonth = allOrders.stream()
                .filter(o -> o.getCreatedAt().isBefore(lastMonth.toInstant(java.time.ZoneOffset.UTC)))
                .count();
        long cancelledOrdersLastMonth = allOrders.stream()
                .filter(o -> o.getStatus() == BookingOrder.BookingStatus.CANCELLED)
                .filter(o -> o.getCreatedAt().isBefore(lastMonth.toInstant(java.time.ZoneOffset.UTC)))
                .count();

        double lastMonthCancellationRate = totalOrdersLastMonth > 0 ? (double) cancelledOrdersLastMonth / totalOrdersLastMonth * 100 : 0;
        double cancellationRateChange = cancellationRate - lastMonthCancellationRate;
        String cancellationRateChangeStr = (cancellationRateChange >= 0 ? "+" : "") + decimalFormat.format(cancellationRateChange) + "%";
        boolean cancellationRatePositive = cancellationRateChange <= 0; // Lower is better

        // Total revenue
        String totalRevenueChange = calculatePercentageChange(lastMonthRevenue, totalRevenue);
        boolean totalRevenuePositive = totalRevenue >= lastMonthRevenue;

        return new AdminMetrics(
                new AdminMetrics.MetricItem(
                        "Активних бронювань",
                        String.valueOf(activeBookings),
                        activeBookingsChange,
                        activeBookingsPositive
                ),
                new AdminMetrics.MetricItem(
                        "Середній чек",
                        "₴" + Math.round(averageCheck),
                        averageCheckChange,
                        averageCheckPositive
                ),
                new AdminMetrics.MetricItem(
                        "Скасувань",
                        decimalFormat.format(cancellationRate) + "%",
                        cancellationRateChangeStr,
                        cancellationRatePositive
                ),
                new AdminMetrics.MetricItem(
                        "Загальний дохід",
                        "₴" + Math.round(totalRevenue),
                        totalRevenueChange,
                        totalRevenuePositive
                )
        );
    }

    private String calculatePercentageChange(double oldValue, double newValue) {
        if (oldValue == 0) {
            return newValue > 0 ? "+100%" : "0%";
        }
        double change = ((newValue - oldValue) / oldValue) * 100;
        return (change >= 0 ? "+" : "") + decimalFormat.format(change) + "%";
    }
}
