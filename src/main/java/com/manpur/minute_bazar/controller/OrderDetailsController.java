package com.manpur.minute_bazar.controller;

import com.manpur.minute_bazar.request.OrderDetailsRequest;
import com.manpur.minute_bazar.response.OrderDetailsResponse;
import com.manpur.minute_bazar.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderDetailsController {
    @Autowired
    private OrderDetailsService service;

    @PostMapping("/id")
    public OrderDetailsResponse createOrder(@RequestBody OrderDetailsRequest request) {
        return service.createOrder(request);
    }

    @GetMapping("/search/{id}")
    public OrderDetailsResponse getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @GetMapping("/orderAll")
    public List<OrderDetailsResponse> getAllOrders() {
        return service.getAllOrders();
    }

    @PutMapping("/{id}")
    public OrderDetailsResponse updateOrder(@PathVariable Long id, @RequestBody OrderDetailsRequest request) {
        return service.updateOrder(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }
}
