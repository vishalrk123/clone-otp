package com.manpur.minute_bazar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private String customerName;
    private String productName;
    private int quantity;
    private double price;
    private LocalDateTime orderDate;

    // Constructors
    public OrderDetails() {}

    public OrderDetails(String orderNumber, String customerName, String productName, int quantity, double price, LocalDateTime orderDate) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
    }

    public void setOrderNumber(Object orderNumber) {
    }

    public void setCustomerName(Object customerName) {
    }

    public void setProductName(Object productName) {
    }

    public void setQuantity(Object quantity) {
    }

    public void setPrice(Object price) {
    }

    public Object getId() {
        return id;
    }

    public Object getOrderNumber() {
        return orderNumber;
    }

    public Object getCustomerName() {
        return customerName;
    }

    public Object getProductName() {
        return productName;
    }

    public Object getQuantity() {
        return quantity;
    }

    public Object getPrice() {
        return price;
    }

    public Object getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime now) {
    }
}
