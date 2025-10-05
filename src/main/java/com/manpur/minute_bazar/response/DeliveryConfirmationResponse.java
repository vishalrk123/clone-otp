package com.manpur.minute_bazar.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryConfirmationResponse {
    private String orderId;
    private boolean confirmed;
    private String message;
}
