package com.divine.code.chainOfResponsibility.array;

// 具体处理器B
public class HandlerB implements IHandler {
    @Override
    public boolean handle() {
        boolean handled = false;
        // 具体的业务逻辑
        // ...
        System.out.println("处理B");
        return handled;
    }
}