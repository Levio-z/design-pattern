package com.divine.code.strategy.file.strategy;

// 快速排序
public class QuickSort implements ISortAlg {
    public void sort(String filePath) {
        System.out.println("使用 QuickSort 排序：" + filePath);
    }
}