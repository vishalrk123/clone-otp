package com.manpur.minute_bazar.response;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long productId;
    private String name;
    private double price;
    private double rating;
    private String imageUrl;
    private String unit;
    private int discount;
    private String category;
}
