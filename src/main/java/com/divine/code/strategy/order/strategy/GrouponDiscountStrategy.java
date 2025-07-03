package com.divine.code.strategy.order.strategy;

import com.divine.code.strategy.order.order.Order;

// GrouponDiscountStrategy.java
public class GrouponDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(Order order) {
        // 团购订单折扣算法（示例：8折）
        return order.getTotalAmount() * 0.2;
    }
}
