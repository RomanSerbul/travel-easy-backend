package com.traveleasy.backend.orders.api;

import com.traveleasy.backend.common.dto.ApiResponse;
import com.traveleasy.backend.orders.model.BookingOrderRequest;
import com.traveleasy.backend.orders.model.BookingOrderResponse;
import com.traveleasy.backend.orders.model.StartWizardRequest;
import com.traveleasy.backend.orders.model.StartWizardResponse;
import com.traveleasy.backend.orders.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/wizard")
    public ResponseEntity<ApiResponse<StartWizardResponse>> startWizard(@Valid @RequestBody StartWizardRequest request) {
        var session = bookingService.startWizard(request.proposalId());
        return ResponseEntity.ok(ApiResponse.of(StartWizardResponse.from(session)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BookingOrderResponse>> confirmBooking(@Valid @RequestBody BookingOrderRequest request) {
        var response = bookingService.confirmBooking(request);
        return ResponseEntity.accepted().body(ApiResponse.of(response));
    }
}
