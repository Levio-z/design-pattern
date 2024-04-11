package com.divine.code.command.commands;

import com.divine.code.command.editor.Editor;

/**
 * 抽象基础命令
 *
 * @author zp
 * @date 2024/04/11
 */
public abstract class Command {
    public Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();
}