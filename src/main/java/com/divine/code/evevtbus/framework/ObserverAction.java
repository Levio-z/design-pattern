package com.divine.code.evevtbus.framework;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Represents an action (method) annotated with @Subscribe, bound to a specific observer instance.
 *
 * This class encapsulates:
 * - `target`: the object instance that owns the method.
 * - `method`: a method annotated with @Subscribe that handles a specific type of event.
 *
 * It is used internally by the ObserverRegistry to manage the mapping from event types
 * to observer methods (observer actions).
 */
public class ObserverAction {
    private final Object target;
    private final Method method;

    public ObserverAction(Object target, Method method) {
        this.target = Objects.requireNonNull(target);
        this.method = Objects.requireNonNull(method);
        this.method.setAccessible(true); // Ensure private methods are callable
    }

    /**
     * Invokes the observer method with the given event.
     * @param event the event object to pass to the method
     */
    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke subscriber method: " + method, e);
        }
    }

    public Object getTarget() {
        return target;
    }

    public Method getMethod() {
        return method;
    }
}

