package com.divine.code.chainOfResponsibility.link;

// 具体处理器A
public class HandlerA extends Handler {
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        // 具体的业务逻辑
        // ...
        System.out.println("处理A");
        return handled;
    }
}