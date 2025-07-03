package com.divine.code.strategy.order.strategy;

import com.divine.code.strategy.order.order.Order;

// DiscountStrategy.java
public interface DiscountStrategy {
    double calDiscount(Order order);
}
