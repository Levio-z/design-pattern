package com.divine.code.iterator;

public interface Iterator<E> {
    boolean hasNext(); // 判断是否还有下一个元素
    void next();       // 移动到下一个元素
    E currentItem();   // 获取当前元素
}