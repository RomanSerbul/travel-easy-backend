package com.traveleasy.backend.orders.repository;

import com.traveleasy.backend.orders.domain.BookingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookingOrderRepository extends JpaRepository<BookingOrder, UUID> {
}
