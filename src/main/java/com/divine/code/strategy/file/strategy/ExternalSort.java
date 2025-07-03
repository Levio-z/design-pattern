package com.divine.code.strategy.file.strategy;

// 外部排序
public class ExternalSort implements ISortAlg {
    public void sort(String filePath) {
        System.out.println("使用 ExternalSort 排序：" + filePath);
    }
}
