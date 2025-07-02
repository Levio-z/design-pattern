package com.divine.code.iterator;

import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator<E>{
    private int cursor; // 当前指针位置
    private ArrayList<E> arrayList; // 存储元素的 ArrayList

    // 构造方法，初始化指针和 ArrayList
    public ArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    // 判断是否有下一个元素
    @Override
    public boolean hasNext() {
        return cursor != arrayList.size(); // 当指针不等于 ArrayList 的大小时，还有下一个元素
    }

    // 将指针移动到下一个元素
    @Override
    public void next() {
        cursor++;
    }

    // 获取当前指向的元素
    @Override
    public E currentItem() {
        if (cursor >= arrayList.size()) { // 如果指针超出范围，抛出异常
            throw new NoSuchElementException();
        }
        return arrayList.get(cursor); // 返回当前指向的元素
    }
}