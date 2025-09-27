package com.manpur.minute_bazar.service;

import com.manpur.minute_bazar.request.OrderDetailsRequest;
import com.manpur.minute_bazar.response.OrderDetailsResponse;

import java.util.List;

public interface OrderDetailsService {
    OrderDetailsResponse createOrder(OrderDetailsRequest request);
    OrderDetailsResponse getOrderById(Long id);
    List<OrderDetailsResponse> getAllOrders();
    OrderDetailsResponse updateOrder(Long id, OrderDetailsRequest request);
    void deleteOrder(Long id);
}
