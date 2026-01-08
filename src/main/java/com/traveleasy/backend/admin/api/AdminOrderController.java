package com.traveleasy.backend.admin.api;

import com.traveleasy.backend.admin.model.OrderDraft;
import com.traveleasy.backend.admin.model.OrderStatusUpdate;
import com.traveleasy.backend.admin.model.OrderSummary;
import com.traveleasy.backend.admin.service.AdminOrderService;
import com.traveleasy.backend.common.dto.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    public AdminOrderController(AdminOrderService adminOrderService) {
        this.adminOrderService = adminOrderService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderSummary>>> listOrders() {
        return ResponseEntity.ok(ApiResponse.of(adminOrderService.listOrders()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderSummary>> createOrder(@Valid @RequestBody OrderDraft draft) {
        return ResponseEntity.ok(ApiResponse.of(adminOrderService.createOrder(draft)));
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<ApiResponse<OrderSummary>> updateOrderStatus(
            @PathVariable UUID orderId,
            @Valid @RequestBody OrderStatusUpdate statusUpdate) {
        return ResponseEntity.ok(ApiResponse.of(
                adminOrderService.updateOrderStatus(orderId, statusUpdate.status())
        ));
    }
}
