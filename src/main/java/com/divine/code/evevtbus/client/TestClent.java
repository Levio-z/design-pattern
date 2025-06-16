package com.divine.code.evevtbus.client;

import com.divine.code.evevtbus.framework.AsyncEventBus;
import com.divine.code.evevtbus.framework.EventBus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClent {
    static ExecutorService executor = Executors.newFixedThreadPool(1);
    public static void main(String[] args) {
        EventBus eventBus = new EventBus(); // 使用同步执行器

        DObserver observer = new DObserver();
        eventBus.register(observer); // 注册观察者

        // 发布事件
        eventBus.post(new PMsg("Hello"));
        eventBus.post(new QMsg(200));

        EventBus eventBus1 = new AsyncEventBus(executor); // 使用同步执行器

        DObserver observer2 = new DObserver();
        eventBus1.register(observer2); // 注册观察者

        // 发布事件
        eventBus1.post(new PMsg("Hello Async EventBus"));
        eventBus1.post(new QMsg(200));
    }
}

