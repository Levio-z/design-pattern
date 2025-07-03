package com.divine.code.chainOfResponsibility.link;

// 抽象处理器类
public abstract class Handler {
    protected Handler successor = null;

    // 设置下一个处理器
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    // 最终的处理方法，使用模板模式
    public final void handle() {
        boolean handled = doHandle();
        if (successor != null && !handled) {
            // 没有处理成功，将请求传递给下一个处理器
            successor.handle();
        }
        // 修改为如下代码，表示无论处理成不成功，都传递给下一个处理器
        // 如果处理成功，可以在这里添加其他逻辑
        //        doHandle();
        //        if (successor != null) {
        //            successor.handle();
        //        }
    }

    // 具体的处理逻辑，由子类实现
    protected abstract boolean doHandle();
}