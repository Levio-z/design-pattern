package com.divine.code.mediator;

public class Input implements Component {
    private String id;
    private String text;

    public Input(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void show() {
        System.out.println(id + " is shown.");
    }

    public void hide() {
        System.out.println(id + " is hidden.");
    }
}