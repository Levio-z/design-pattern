package com.divine.code.mediator;

public class Text {
    private String text;

    public Text(String text) {
        this.text = text;
    }
    public void show() {
        System.out.println("Text is shown.");
    }

    public void hide() {
        System.out.println("Text is hidden.");
    }
}
