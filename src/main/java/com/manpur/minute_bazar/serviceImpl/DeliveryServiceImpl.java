package com.manpur.minute_bazar.serviceImpl;

import com.manpur.minute_bazar.convertor.DeliveryConvertor;
import com.manpur.minute_bazar.model.Delivery;
import com.manpur.minute_bazar.repository.DeliveryRepository;
import com.manpur.minute_bazar.request.DeliveryConfirmationRequest;
import com.manpur.minute_bazar.response.DeliveryConfirmationResponse;
import com.manpur.minute_bazar.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Override
    public DeliveryConfirmationResponse confirmDelivery(DeliveryConfirmationRequest request) {
        Delivery delivery = deliveryRepository.findByOrderId(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (delivery.getOtp().equals(request.getOtp())) {
            delivery.setConfirmed(true);
            deliveryRepository.save(delivery);
        }

        return DeliveryConvertor.toResponse(delivery);
    }
}
