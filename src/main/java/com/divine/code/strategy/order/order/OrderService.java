package com.divine.code.strategy.order.order;

import com.divine.code.strategy.order.factory.DiscountStrategyFactory;
import com.divine.code.strategy.order.strategy.DiscountStrategy;

// OrderService.java
public class OrderService {
    public double discount(Order order) {
        OrderType type = order.getType();
        DiscountStrategy strategy = DiscountStrategyFactory.getDiscountStrategy(type);
        return strategy.calDiscount(order);
    }
}
