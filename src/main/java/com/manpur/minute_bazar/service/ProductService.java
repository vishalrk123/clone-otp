package com.manpur.minute_bazar.service;

import com.manpur.minute_bazar.request.ProductRequest;
import com.manpur.minute_bazar.response.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponse saveProduct(ProductRequest request);
    List<ProductResponse> getAllProducts(String search);
    ProductResponse getProductById(long productId);

    List<ProductResponse> saveAllProduct(List<ProductRequest> requests);
}
