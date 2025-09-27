package com.manpur.minute_bazar.response.availabilty;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemAvailabilityResponse {
    private long productId;
    private int availableQuantity;
    private boolean inStock;
}
