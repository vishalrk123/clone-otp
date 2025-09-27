package com.manpur.minute_bazar.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    // Getters & Setters
    // Getters & Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;   // auto-increment primary key

//    @Column(nullable = false, unique = true)
//    private UUID productId; // unique product code

    private String name;
    private double price;
    private double rating;
    private String imageUrl;
    private String unit;
    private int discount;
    private String category;

}
