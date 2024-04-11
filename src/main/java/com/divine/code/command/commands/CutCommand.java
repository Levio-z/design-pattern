package com.divine.code.command.commands;


import com.divine.code.command.editor.Editor;

/**
 * 将文字剪切到剪贴板
 *
 * @author zp
 * @date 2024/04/11
 */
public class CutCommand extends Command {

    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.textField.getSelectedText().isEmpty()) return false;
        // 备份text
        backup();
        String source = editor.textField.getText();
        editor.clipboard = editor.textField.getSelectedText();
        editor.textField.setText(cutString(source));
        return true;
    }

    /**
     * 将选中文字之外的拼接借来，放到text中
     *
     * @param source
     * @return {@link String}
     */
    private String cutString(String source) {
        // 截取字符串开始到索引之前的内容，不包含这个索引
        String start = source.substring(0, editor.textField.getSelectionStart());
        // 从结束索引开始截取
        String end = source.substring(editor.textField.getSelectionEnd());
        return start + end;
    }
}