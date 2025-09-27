package com.manpur.minute_bazar.service;

import com.manpur.minute_bazar.request.availability.ItemsAvailabilityRequest;
import com.manpur.minute_bazar.response.availabilty.ItemsAvailabilityResponse;

public interface CheckoutService {
    ItemsAvailabilityResponse checkAvailability(ItemsAvailabilityRequest request);
}
