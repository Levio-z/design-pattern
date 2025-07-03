package com.divine.code.strategy.order.strategy;

import com.divine.code.strategy.order.order.Order;

// PromotionDiscountStrategy.java
public class PromotionDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(Order order) {
        // 促销订单折扣算法（示例：减 50）
        return 50.0;
    }
}
