package com.manpur.minute_bazar.repository;

import com.manpur.minute_bazar.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
