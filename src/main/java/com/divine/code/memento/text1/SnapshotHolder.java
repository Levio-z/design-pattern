package com.divine.code.memento.text1;

import java.util.Stack;

public class SnapshotHolder {

    public Stack<InputText> snapshots = new Stack<>();

    public InputText popSnapshot() {

        return snapshots.pop();
    }

    public void pushSnapshot(InputText inputText) {

        InputText deepClonedInputText = new InputText();
        deepClonedInputText.setText(inputText.getText());
        snapshots.push(deepClonedInputText);
    }

}
