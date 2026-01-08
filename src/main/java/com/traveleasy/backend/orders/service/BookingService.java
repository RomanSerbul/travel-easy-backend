package com.traveleasy.backend.orders.service;

import com.traveleasy.backend.orders.model.BookingOrderRequest;
import com.traveleasy.backend.orders.model.BookingOrderResponse;
import com.traveleasy.backend.orders.model.BookingWizardSession;

public interface BookingService {
    BookingWizardSession startWizard(String proposalId);

    BookingOrderResponse confirmBooking(BookingOrderRequest request);
}
