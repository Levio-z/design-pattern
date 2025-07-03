package com.divine.code.strategy.order.factory;// DiscountStrategyFactory.java
import com.divine.code.strategy.order.strategy.GrouponDiscountStrategy;
import com.divine.code.strategy.order.order.OrderType;
import com.divine.code.strategy.order.strategy.DiscountStrategy;
import com.divine.code.strategy.order.strategy.NormalDiscountStrategy;
import com.divine.code.strategy.order.strategy.PromotionDiscountStrategy;

import java.util.Map;
import java.util.HashMap;

public class DiscountStrategyFactory {
    private static final Map<OrderType, DiscountStrategy> strategies = new HashMap<>();

    static {
        strategies.put(OrderType.NORMAL, new NormalDiscountStrategy());
        strategies.put(OrderType.GROUPON, new GrouponDiscountStrategy());
        strategies.put(OrderType.PROMOTION, new PromotionDiscountStrategy());
    }

    public static DiscountStrategy getDiscountStrategy(OrderType type) {
        return strategies.get(type);
    }
}
