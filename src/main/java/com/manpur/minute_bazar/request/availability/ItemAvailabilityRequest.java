package com.manpur.minute_bazar.request.availability;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemAvailabilityRequest {
    private long productId;
    private int quantityBuy;
}
