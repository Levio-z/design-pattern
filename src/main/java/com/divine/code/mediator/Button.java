package com.divine.code.mediator;

// 模拟的控件类
public class Button implements Component {
    private String id;
    private OnClickListener listener;
    private View view;

    public Button(String id) {
        this.id = id;
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void onClick() {
        if (listener != null) {
            listener.onClick(view);
        }
    }
}