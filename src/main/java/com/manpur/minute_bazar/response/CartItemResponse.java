package com.manpur.minute_bazar.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponse {
    private Long productId;
    private int quantity;
}
