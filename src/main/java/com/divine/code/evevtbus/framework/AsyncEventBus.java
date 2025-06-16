package com.divine.code.evevtbus.framework;

import java.util.concurrent.Executor;

public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor); // 使用用户注入的线程池
    }
}
