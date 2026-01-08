package com.traveleasy.backend.orders.service;

import com.traveleasy.backend.notifications.model.NotificationPayload;
import com.traveleasy.backend.notifications.service.NotificationService;
import com.traveleasy.backend.orders.domain.BookingOrder;
import com.traveleasy.backend.orders.model.BookingOrderRequest;
import com.traveleasy.backend.orders.model.BookingOrderResponse;
import com.traveleasy.backend.orders.model.BookingWizardSession;
import com.traveleasy.backend.orders.repository.BookingOrderRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Service
@Primary
public class JpaBookingService implements BookingService {

    private final BookingOrderRepository bookingOrderRepository;
    private final NotificationService notificationService;

    public JpaBookingService(BookingOrderRepository bookingOrderRepository,
                             NotificationService notificationService) {
        this.bookingOrderRepository = bookingOrderRepository;
        this.notificationService = notificationService;
    }

    @Override
    public BookingWizardSession startWizard(String proposalId) {
        var expiry = Instant.now().plus(30, ChronoUnit.MINUTES);
        return BookingWizardSession.start(proposalId, expiry);
    }

    @Override
    @Transactional
    public BookingOrderResponse confirmBooking(BookingOrderRequest request) {
        var order = new BookingOrder(
                request.proposalId(),
                request.customerName(),
                request.customerEmail(),
                request.customerPhone(),
                request.startDate(),
                request.nights(),
                request.guests(),
                request.addOns(),
                request.notes()
        );

        var saved = bookingOrderRepository.save(order);

        var payload = new NotificationPayload(
                "booking-confirmation",
                Map.of(
                        "orderId", saved.getId(),
                        "proposalId", saved.getProposalId(),
                        "customerName", saved.getCustomerName(),
                        "email", saved.getCustomerEmail(),
                        "subject", "Travel Easy: підтвердження запиту"
                ));
        notificationService.sendToAll(payload);

        return new BookingOrderResponse(
                saved.getId(),
                saved.getStatus().name(),
                saved.getCreatedAt()
        );
    }
}
