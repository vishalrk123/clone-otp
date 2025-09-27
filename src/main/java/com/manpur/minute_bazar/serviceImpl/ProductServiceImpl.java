package com.manpur.minute_bazar.serviceImpl;

import com.manpur.minute_bazar.convertor.ProductConvertor;
import com.manpur.minute_bazar.model.Product;
import com.manpur.minute_bazar.repository.ProductRepository;
import com.manpur.minute_bazar.request.ProductRequest;
import com.manpur.minute_bazar.response.ProductResponse;
import com.manpur.minute_bazar.service.ProductService;
import com.manpur.minute_bazar.utils.ProductSearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConvertor productConvertor;

    @Autowired
    private ProductSearchUtil productSearchUtil;


    @Override
    public ProductResponse saveProduct(ProductRequest request) {
        Product product = productConvertor.toEntity(request);
        Product saved = productRepository.save(product);
        return productConvertor.toResponse(saved);
    }

    @Override
    public List<ProductResponse> getAllProducts(String search) {
        if (search == null || search.isBlank() || search.isEmpty()) {
            return productRepository.findAll().stream().map(product -> productConvertor.toResponse(product)).toList();
        }

        Set<Product> products = productSearchUtil.search(search);

        for (Product product : productRepository.findAll()) {  // keep a cached list of all products
            if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                products.add(product);
            }
        }

        return products.stream().map(product -> productConvertor.toResponse(product)).toList();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        Product product = productRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        return productConvertor.toResponse(product);
    }

    /**
     * @param requests
     * @return
     */
    @Override
    public List<ProductResponse> saveAllProduct(List<ProductRequest> requests) {
        List<Product> products = requests.stream().map(request -> productConvertor.toEntity(request)).toList();
        List<Product> savedProduct = productRepository.saveAll(products);
        return savedProduct.stream()
                .map(productConvertor::toResponse)
                .collect(Collectors.toList());
    }
}
