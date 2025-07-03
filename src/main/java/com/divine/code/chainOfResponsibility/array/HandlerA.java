package com.divine.code.chainOfResponsibility.array;

// 具体处理器A
public class HandlerA implements IHandler {
    @Override
    public boolean handle() {
        boolean handled = true;
        // 具体的业务逻辑
        // ...
        System.out.println("处理A");
        return handled;
    }
}