package com.divine.code.memento.text1;

public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input).append(" ");
    }

    public void setText(String text) {
        this.text.replace(0, this.text.length(), text);
    }
}

