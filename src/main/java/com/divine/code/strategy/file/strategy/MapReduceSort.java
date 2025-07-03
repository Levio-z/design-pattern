package com.divine.code.strategy.order.file.strategy;

// MapReduce 排序
public class MapReduceSort implements ISortAlg {
    public void sort(String filePath) {
        System.out.println("使用 MapReduceSort 排序：" + filePath);
    }
}