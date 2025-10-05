package com.manpur.minute_bazar.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryConfirmationRequest {
    private String orderId;
    private String otp;
}
