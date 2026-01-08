package com.traveleasy.backend.orders.service;

import com.traveleasy.backend.orders.model.BookingOrderRequest;
import com.traveleasy.backend.orders.model.BookingOrderResponse;
import com.traveleasy.backend.orders.model.BookingWizardSession;
import com.traveleasy.backend.notifications.model.NotificationPayload;
import com.traveleasy.backend.notifications.service.NotificationService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;

@Service
public class InMemoryBookingService implements BookingService {

    private final NotificationService notificationService;

    public InMemoryBookingService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public BookingWizardSession startWizard(String proposalId) {
        var expiry = Instant.now().plus(30, ChronoUnit.MINUTES);
        return BookingWizardSession.start(proposalId, expiry);
    }

    @Override
    public BookingOrderResponse confirmBooking(BookingOrderRequest request) {
        // TODO replace stub with persistence and notification fan-out
        var response = new BookingOrderResponse(UUID.randomUUID(), "PENDING_CONFIRMATION", Instant.now());
        var payload = new NotificationPayload(
                "booking-confirmation",
                Map.of(
                        "orderId", response.orderId(),
                        "proposalId", request.proposalId(),
                        "customerName", request.customerName(),
                        "email", request.customerEmail(),
                        "subject", "Travel Easy: підтвердження запиту"
                ));
        notificationService.sendToAll(payload);
        return response;
    }
}
