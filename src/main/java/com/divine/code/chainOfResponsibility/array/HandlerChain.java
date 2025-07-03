package com.divine.code.chainOfResponsibility.array;

import java.util.ArrayList;
import java.util.List;

// 职责链管理类
public class HandlerChain {
    private List<IHandler> handlers = new ArrayList<>();

    // 添加处理器到链中
    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    // 处理请求
    public void handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            if (handled) {
                break;
            }
        }
    }
}