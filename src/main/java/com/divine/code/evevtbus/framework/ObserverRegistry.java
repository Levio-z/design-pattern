package com.divine.code.evevtbus.framework;


import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverRegistry {
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            registry.computeIfAbsent(eventType, k -> new CopyOnWriteArraySet<>())
                    .addAll(eventActions);
        }
    }

    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            // 确定此 Class 对象表示的类或接口是否与指定参数表示的类或接口相同，或者是该 Class 类或接口的超类或超接口。
            if (eventType.isAssignableFrom(postedEventType)) {
                matchedObservers.addAll(entry.getValue());
            }
        }
        return matchedObservers;
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        for (Method method : getAnnotatedMethods(observer.getClass())) {
            Class<?> eventType = method.getParameterTypes()[0];
            observerActions.computeIfAbsent(eventType, k -> new ArrayList<>())
                    .add(new ObserverAction(observer, method));
        }
        return observerActions;
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Preconditions.checkArgument(
                        method.getParameterTypes().length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters. Must have exactly 1.",
                        method, method.getParameterTypes().length
                );
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}

