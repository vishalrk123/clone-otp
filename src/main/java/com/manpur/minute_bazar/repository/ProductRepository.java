package com.manpur.minute_bazar.repository;

import com.manpur.minute_bazar.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, BigInteger>{
    Optional<Product> findByProductId(long productId);
}
