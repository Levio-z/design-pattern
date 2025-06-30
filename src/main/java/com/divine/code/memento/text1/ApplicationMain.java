package com.divine.code.memento.text1;

import java.util.Scanner;

public class ApplicationMain {

    public static void main(String[] args) {

        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Text Editor started. Type ':list' to show text, ':undo' to undo last input, and 'exit' to quit.");

        while (scanner.hasNext()) {
            String input = scanner.next();

            if (input.equals(":list")) {
                System.out.println(inputText.getText());
            } else if (input.equals(":undo")) {
                if (!snapshotHolder.snapshots.isEmpty()) {
                    InputText snapshot = snapshotHolder.popSnapshot();
                    inputText.setText(snapshot.getText());
                } else {
                    System.out.println("No previous input to undo.");
                }
            } else if (input.equals("exit")) {
                break;
            } else {
                snapshotHolder.pushSnapshot(inputText);
                inputText.append(input);
            }
        }

        scanner.close();
    }

}
