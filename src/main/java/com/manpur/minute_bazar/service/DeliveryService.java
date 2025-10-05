package com.manpur.minute_bazar.service;

import com.manpur.minute_bazar.request.DeliveryConfirmationRequest;
import com.manpur.minute_bazar.response.DeliveryConfirmationResponse;
public interface DeliveryService {
    DeliveryConfirmationResponse confirmDelivery(DeliveryConfirmationRequest request);
}
