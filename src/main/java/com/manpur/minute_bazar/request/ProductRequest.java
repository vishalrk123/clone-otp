package com.manpur.minute_bazar.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequest {
    // Getters & Setters
    private String name;
    private double price;
    private double rating;
    private String imageUrl;
    private String unit;
    private int discount;
    private String category;

}
