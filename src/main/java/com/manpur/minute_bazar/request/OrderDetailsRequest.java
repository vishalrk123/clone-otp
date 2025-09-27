package com.manpur.minute_bazar.request;

public class OrderDetailsRequest {
    private String orderNumber;
    private String customerName;
    private String productName;
    private int quantity;
    private double price;

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
}
