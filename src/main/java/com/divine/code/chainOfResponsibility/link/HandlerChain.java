package com.divine.code.chainOfResponsibility.link;

// 职责链管理类
public class HandlerChain {

    private Handler head = null;

    private Handler tail = null;

    // 添加处理器到链中
    public void addHandler(Handler handler) {

        handler.setSuccessor(null);

        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;
    }

    // 处理请求
    public void handle() {

        if (head != null) {
            head.handle();
        }
    }

}