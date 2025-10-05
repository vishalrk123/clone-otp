package com.manpur.minute_bazar.controller;

import com.manpur.minute_bazar.request.DeliveryConfirmationRequest;
import com.manpur.minute_bazar.response.DeliveryConfirmationResponse;
import com.manpur.minute_bazar.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delivery")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping("/confirm")
    public DeliveryConfirmationResponse confirmDelivery(
            @RequestBody DeliveryConfirmationRequest request) {
        return deliveryService.confirmDelivery(request);
    }
}
