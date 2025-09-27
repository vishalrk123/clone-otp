package com.manpur.minute_bazar.controller.proceedtocheckout;

import com.manpur.minute_bazar.request.availability.ItemsAvailabilityRequest;
import com.manpur.minute_bazar.response.availabilty.ItemsAvailabilityResponse;
import com.manpur.minute_bazar.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping("/checkAvailability")
    public ItemsAvailabilityResponse checkAvailability(@RequestBody ItemsAvailabilityRequest request) {
        return checkoutService.checkAvailability(request);
    }
}
