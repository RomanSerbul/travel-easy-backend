package com.traveleasy.backend.admin.service;

import com.traveleasy.backend.admin.model.OrderDraft;
import com.traveleasy.backend.admin.model.OrderSummary;
import com.traveleasy.backend.catalog.repository.TourProposalRepository;
import com.traveleasy.backend.orders.domain.BookingOrder;
import com.traveleasy.backend.orders.repository.BookingOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class JpaAdminOrderService implements AdminOrderService {

    private final BookingOrderRepository bookingOrderRepository;
    private final TourProposalRepository tourProposalRepository;

    public JpaAdminOrderService(BookingOrderRepository bookingOrderRepository, TourProposalRepository tourProposalRepository) {
        this.bookingOrderRepository = bookingOrderRepository;
        this.tourProposalRepository = tourProposalRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderSummary> listOrders() {
        return bookingOrderRepository.findAll().stream()
                .map(this::toSummary)
                .toList();
    }

    @Override
    @Transactional
    public OrderSummary createOrder(OrderDraft draft) {
        var order = new BookingOrder(
                draft.proposalId(),
                draft.customerName(),
                draft.customerEmail(),
                draft.customerPhone(),
                draft.startDate(),
                draft.nights(),
                draft.guests(),
                draft.addOns(),
                draft.notes()
        );
        var saved = bookingOrderRepository.save(order);
        return toSummary(saved);
    }

    @Override
    @Transactional
    public OrderSummary updateOrderStatus(java.util.UUID orderId, String status) {
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }
        
        var order = bookingOrderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));

        BookingOrder.BookingStatus newStatus;
        try {
            newStatus = BookingOrder.BookingStatus.valueOf(status);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }

        order.updateStatus(newStatus);
        var saved = bookingOrderRepository.save(order);
        return toSummary(saved);
    }

    private OrderSummary toSummary(BookingOrder order) {
        var proposalTitle = tourProposalRepository.findBySlug(order.getProposalId())
                .map(p -> p.getTitle())
                .orElse(order.getProposalId());
        return new OrderSummary(
                order.getId(),
                order.getProposalId(),
                proposalTitle,
                order.getCustomerName(),
                order.getCustomerEmail(),
                order.getCustomerPhone(),
                order.getStartDate(),
                order.getNights(),
                order.getGuests(),
                order.getStatus().name(),
                order.getCreatedAt().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME)
        );
    }
}
