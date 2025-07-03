package com.divine.code.strategy.order.strategy;

import com.divine.code.strategy.order.order.Order;

// NormalDiscountStrategy.java
public class NormalDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(Order order) {
        // 普通订单折扣算法（示例：无折扣）
        return order.getDiscount();
    }
}
