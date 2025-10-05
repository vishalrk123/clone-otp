package com.manpur.minute_bazar.repository;

import com.manpur.minute_bazar.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findByOrderId(String orderId);
}
