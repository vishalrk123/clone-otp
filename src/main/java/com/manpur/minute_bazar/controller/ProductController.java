package com.manpur.minute_bazar.controller;

import com.manpur.minute_bazar.request.ProductRequest;
import com.manpur.minute_bazar.response.ProductResponse;
import com.manpur.minute_bazar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ProductResponse saveData(@RequestBody ProductRequest request) {
        return productService.saveProduct(request);
    }

    @PostMapping("/saveAll")
    public List<ProductResponse> saveAllData(@RequestBody List<ProductRequest> requests) {
        return productService.saveAllProduct(requests);
    }

    @GetMapping("/getAll")
    public List<ProductResponse> getAllProducts(@Param("search") String search) {
        return productService.getAllProducts(search);
    }

    @GetMapping("/search/{productId}")
    public ProductResponse getProductById(@PathVariable long productId) {
        return productService.getProductById(productId);
    }
}
