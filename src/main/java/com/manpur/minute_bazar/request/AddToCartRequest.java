package com.manpur.minute_bazar.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddToCartRequest {
    private Long userId;
    private Long productId;
    private int quantity;
}
