package com.manpur.minute_bazar.serviceImpl;

import com.manpur.minute_bazar.model.Inventory;
import com.manpur.minute_bazar.repository.InventoryRepository;
import com.manpur.minute_bazar.request.availability.ItemAvailabilityRequest;
import com.manpur.minute_bazar.request.availability.ItemsAvailabilityRequest;
import com.manpur.minute_bazar.response.availabilty.ItemAvailabilityResponse;
import com.manpur.minute_bazar.response.availabilty.ItemsAvailabilityResponse;
import com.manpur.minute_bazar.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final InventoryRepository inventoryRepository;

    /**
     * @param request
     * @return
     */
    @Override
    public ItemsAvailabilityResponse checkAvailability(ItemsAvailabilityRequest request) {
        List<ItemAvailabilityResponse> itemAvailabilityList = new ArrayList<>();
        for(ItemAvailabilityRequest itemAvailabilityRequest : request.getItemsAvailabilityRequest()) {
            Inventory inventory = inventoryRepository.findByProductId(itemAvailabilityRequest.getProductId());
            if(inventory.getStockQuantity() < itemAvailabilityRequest.getQuantityBuy()) {
                itemAvailabilityList.add(ItemAvailabilityResponse.builder()
                        .availableQuantity(inventory.getStockQuantity())
                        .inStock(false)
                        .productId(inventory.getProductId())
                        .build());
            }
        }

        return ItemsAvailabilityResponse.builder()
                .itemsAvailabilityResponse(itemAvailabilityList)
                .build();
    }
}
