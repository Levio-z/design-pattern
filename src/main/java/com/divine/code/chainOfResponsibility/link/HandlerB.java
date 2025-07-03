package com.divine.code.chainOfResponsibility.link;

// 具体处理器B
public class HandlerB extends Handler {
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        // 具体的业务逻辑
        // ...
        System.out.println("处理B");
        return handled;
    }
}