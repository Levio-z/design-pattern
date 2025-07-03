package com.divine.code.strategy.order;

import com.divine.code.strategy.order.order.Order;
import com.divine.code.strategy.order.order.OrderService;
import com.divine.code.strategy.order.order.OrderType;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(OrderType.NORMAL, 300.0,100.0);
        Order order2 = new Order(OrderType.PROMOTION, 300.0);
        Order order3 = new Order(OrderType.GROUPON, 300.0);

        OrderService service = new OrderService();

        System.out.println("订单1折扣: " + service.discount(order1)); // 输出 100.0
        System.out.println("订单2折扣: " + service.discount(order2)); // 输出 50.0
        System.out.println("订单3折扣: " + service.discount(order3)); // 输出 60.0
    }
}
