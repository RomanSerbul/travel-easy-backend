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
import java.util.HashMap;
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

        var variables = new HashMap<String, Object>();
        variables.put("orderId", saved.getId());
        variables.put("proposalId", saved.getProposalId());
        variables.put("tourTitle", request.tourTitle() != null ? request.tourTitle() : saved.getProposalId());
        variables.put("customerName", saved.getCustomerName());
        variables.put("email", saved.getCustomerEmail());
        variables.put("phone", saved.getCustomerPhone() != null ? saved.getCustomerPhone() : "");
        variables.put("startDate", saved.getStartDate() != null ? saved.getStartDate() : "");
        variables.put("nights", saved.getNights());
        variables.put("guests", saved.getGuests());
        variables.put("addOns", saved.getAddOns() != null ? String.join(", ", saved.getAddOns()) : "");
        variables.put("notes", saved.getNotes() != null ? saved.getNotes() : "");
        variables.put("subject", "Travel Easy: підтвердження бронювання #" + saved.getOrderNumber());
        variables.put("orderId", saved.getOrderNumber());

        var payload = new NotificationPayload("booking-confirmation", variables);
        notificationService.sendToAll(payload);

        return new BookingOrderResponse(
                saved.getId(),
                saved.getOrderNumber(),
                saved.getStatus().name(),
                saved.getCreatedAt()
        );
    }
}
