package com.manpur.minute_bazar.serviceImpl;

import com.manpur.minute_bazar.convertor.OrderDetailsConvertor;
import com.manpur.minute_bazar.model.OrderDetails;
import com.manpur.minute_bazar.repository.OrderDetailsRepository;
import com.manpur.minute_bazar.request.OrderDetailsRequest;
import com.manpur.minute_bazar.response.OrderDetailsResponse;
import com.manpur.minute_bazar.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private OrderDetailsRepository repository;

    @Override
    public OrderDetailsResponse createOrder(OrderDetailsRequest request) {
        OrderDetails order = OrderDetailsConvertor.toEntity(request);
        OrderDetails savedOrder = repository.save(order);
        return OrderDetailsConvertor.toResponse(savedOrder);
    }

    @Override
    public List<OrderDetailsResponse> getAllOrders() {
        return (List<OrderDetailsResponse>) repository.findAll().stream()
                .map(OrderDetailsConvertor::toResponse)
                .collect(Collectors.toList());
    }
    @Override
    public OrderDetailsResponse getOrderById(Long id) {
        OrderDetails order = repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderDetailsConvertor.toResponse(order);
    }

    @Override
    public OrderDetailsResponse updateOrder(Long id, OrderDetailsRequest request) {
        OrderDetails order = repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setOrderNumber(request.getOrderNumber());
        order.setCustomerName(request.getCustomerName());
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());
        OrderDetails updatedOrder = repository.save(order);
        return OrderDetailsConvertor.toResponse(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

}
