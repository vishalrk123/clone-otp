package com.manpur.minute_bazar.repository;

import com.manpur.minute_bazar.model.Inventory;
import com.manpur.minute_bazar.request.availability.ItemAvailabilityRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByProductId(long productId);
}
