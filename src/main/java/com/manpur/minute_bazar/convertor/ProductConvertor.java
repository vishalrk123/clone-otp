package com.manpur.minute_bazar.convertor;

import com.manpur.minute_bazar.model.Product;
import com.manpur.minute_bazar.request.ProductRequest;
import com.manpur.minute_bazar.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductConvertor {

    // Convert request DTO → entity
    public Product toEntity(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .rating(request.getRating())
                .imageUrl(request.getImageUrl())
                .unit(request.getUnit())
                .discount(request.getDiscount())
                .category(request.getCategory())
                .build();
    }

    // Convert entity → response DTO
    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .rating(product.getRating())
                .imageUrl(product.getImageUrl())
                .unit(product.getUnit())
                .discount(product.getDiscount())
                .category(product.getCategory())
                .build();
    }
}

