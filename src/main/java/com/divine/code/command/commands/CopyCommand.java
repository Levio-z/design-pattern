package com.divine.code.command.commands;


import com.divine.code.command.editor.Editor;

/**
 * 将所选文字复制到剪贴板
 *
 * @author zp
 * @date 2024/04/11
 */
public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}