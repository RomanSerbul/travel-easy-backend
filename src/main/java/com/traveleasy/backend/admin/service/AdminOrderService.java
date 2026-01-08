package com.traveleasy.backend.admin.service;

import com.traveleasy.backend.admin.model.OrderDraft;
import com.traveleasy.backend.admin.model.OrderSummary;

import java.util.List;
import java.util.UUID;

public interface AdminOrderService {
    List<OrderSummary> listOrders();

    OrderSummary createOrder(OrderDraft draft);

    OrderSummary updateOrderStatus(UUID orderId, String status);
}
