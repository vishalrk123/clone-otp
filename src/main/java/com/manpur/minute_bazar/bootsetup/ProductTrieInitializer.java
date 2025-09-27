package com.manpur.minute_bazar.bootsetup;

import com.manpur.minute_bazar.model.Product;
import com.manpur.minute_bazar.repository.ProductRepository;
import com.manpur.minute_bazar.utils.ProductSearchUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductTrieInitializer {

    private final ProductRepository productRepository;
    private final ProductSearchUtil productSearchUtil;

//    public ProductTrieInitializer(ProductRepository productRepository,
//                                  ProductSearchUtil productSearchUtil) {
//        this.productRepository = productRepository;
//        this.productSearchUtil = productSearchUtil;
//    }

    @PostConstruct
    public void initTrie() {
        List<Product> products = productRepository.findAll();
        productSearchUtil.insertAll(products);
        System.out.println("✅ Product Trie initialized with " + products.size() + " products");
    }
}
