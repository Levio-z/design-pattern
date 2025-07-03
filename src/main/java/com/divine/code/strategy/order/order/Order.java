package com.divine.code.strategy.order.order;

// Order.java
public class Order {
    private OrderType type;
    private double totalAmount;
    private double discount;

    public Order(OrderType type, double totalAmount) {
        this(type, totalAmount,0.0);
    }

    public Order(OrderType type, double totalAmount,double discount) {
        this.type = type;
        this.totalAmount = totalAmount;
        this.discount = discount;
    }

    public OrderType getType() {
        return type;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getDiscount() {
        return discount;
    }
}
