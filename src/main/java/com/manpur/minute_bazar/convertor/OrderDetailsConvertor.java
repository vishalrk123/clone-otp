package com.manpur.minute_bazar.convertor;

import com.manpur.minute_bazar.model.OrderDetails;
import com.manpur.minute_bazar.request.OrderDetailsRequest;
import com.manpur.minute_bazar.response.OrderDetailsResponse;

public class OrderDetailsConvertor {
    public static OrderDetails toEntity(OrderDetailsRequest request) {
        OrderDetails order = new OrderDetails();
        order.setOrderNumber(request.getOrderNumber());
        order.setCustomerName(request.getCustomerName());
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());
        order.setOrderDate(java.time.LocalDateTime.now());
        return order;
    }

    public static OrderDetailsResponse toResponse(OrderDetails order) {
        OrderDetailsResponse response = new OrderDetailsResponse();
        response.setId(order.getId());
        response.setOrderNumber(order.getOrderNumber());
        response.setCustomerName(order.getCustomerName());
        response.setProductName(order.getProductName());
        response.setQuantity(order.getQuantity());
        response.setPrice(order.getPrice());
        response.setOrderDate(order.getOrderDate());
        return response;
    }
}
