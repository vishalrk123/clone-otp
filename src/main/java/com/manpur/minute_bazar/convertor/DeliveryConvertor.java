package com.manpur.minute_bazar.convertor;

import com.manpur.minute_bazar.model.Delivery;
import com.manpur.minute_bazar.response.DeliveryConfirmationResponse;
public class DeliveryConvertor {

    public static DeliveryConfirmationResponse toResponse(Delivery delivery) {
        return DeliveryConfirmationResponse.builder()
                .orderId(delivery.getOrderId())
                .confirmed(delivery.isConfirmed())
                .message(delivery.isConfirmed() ?
                        "Delivery confirmed successfully." :
                        "OTP verification failed.")
                .build();
    }
}
