package com.divine.code.evevtbus.framework;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

public class EventBus {
    private final Executor executor;
    private final ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor()); // 实际为同步执行
    }

    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object observer) {
        registry.register(observer);
    }

    public void post(Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction action : observerActions) {
            executor.execute(() -> action.execute(event)); // Runnable 封装成异步接口
        }
    }
}

