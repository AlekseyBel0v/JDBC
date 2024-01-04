package com.belov.jdbc;

public class Order {
    private String customerName;
    private String productName;

    public Order(String customerName, String productName) {
        this.customerName = customerName;
        this.productName = productName;
    }
}