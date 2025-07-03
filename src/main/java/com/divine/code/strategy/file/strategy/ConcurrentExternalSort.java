package com.divine.code.strategy.order.file.strategy;

// 并发外部排序
public class ConcurrentExternalSort implements ISortAlg {
    public void sort(String filePath) {
        System.out.println("使用 ConcurrentExternalSort 排序：" + filePath);
    }
}