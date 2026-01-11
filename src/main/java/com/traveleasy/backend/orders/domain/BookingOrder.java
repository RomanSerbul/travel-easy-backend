package com.traveleasy.backend.orders.domain;

import jakarta.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "booking_orders")
@DynamicInsert
public class BookingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Generated(GenerationTime.INSERT)
    @Column(name = "order_number", nullable = false, unique = true, insertable = false, updatable = false)
    private Long orderNumber;

    @Column(name = "proposal_id", nullable = false)
    private String proposalId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "customer_phone", nullable = false)
    private String customerPhone;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private int nights;

    @Column(nullable = false)
    private int guests;

    @ElementCollection
    @CollectionTable(name = "booking_order_addons", joinColumns = @JoinColumn(name = "booking_order_id"))
    @Column(name = "addon")
    private List<String> addOns = new ArrayList<>();

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    protected BookingOrder() {
    }

    public BookingOrder(String proposalId, String customerName, String customerEmail,
                        String customerPhone, LocalDate startDate, int nights, int guests,
                        List<String> addOns, String notes) {
        this.proposalId = proposalId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.startDate = startDate;
        this.nights = nights;
        this.guests = guests;
        this.addOns = addOns != null ? new ArrayList<>(addOns) : new ArrayList<>();
        this.notes = notes;
        this.status = BookingStatus.PENDING_CONFIRMATION;
    }

    public UUID getId() {
        return id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public String getProposalId() {
        return proposalId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getNights() {
        return nights;
    }

    public int getGuests() {
        return guests;
    }

    public List<String> getAddOns() {
        return new ArrayList<>(addOns);
    }

    public String getNotes() {
        return notes;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void updateStatus(BookingStatus newStatus) {
        this.status = newStatus;
    }

    public enum BookingStatus {
        PENDING_CONFIRMATION,
        CONFIRMED,
        CANCELLED,
        ARCHIVED
    }
}
