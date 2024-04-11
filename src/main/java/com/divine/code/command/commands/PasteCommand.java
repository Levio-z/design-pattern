package com.divine.code.command.commands;


import com.divine.code.command.editor.Editor;

/**
 * 从剪贴板粘贴文字
 *
 * @author zp
 * @date 2024/04/11
 */
public class PasteCommand extends Command {

    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;

        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}