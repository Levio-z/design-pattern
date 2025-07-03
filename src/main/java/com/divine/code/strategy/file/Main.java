package com.divine.code.strategy.file;

import com.divine.code.strategy.file.use.Sorter;

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.sortFile("1.txt"); // 自动根据大小选择策略
    }
}
