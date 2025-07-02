package com.divine.code.iterator;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator<E>{
    private int cursor; // 当前指针位置
    private MyArrayList<E> myArrayList; // 存储元素的 ArrayList
    private int lastRet = -1;
    private int expectedModCount;

    // 构造方法，初始化指针和 ArrayList
    public ArrayIterator(MyArrayList<E> myArrayList) {
        this.cursor = 0;
        this.myArrayList = myArrayList;
        this.expectedModCount = myArrayList.getModCount();
    }

    // 判断是否有下一个元素
    @Override
    public boolean hasNext() {
        checkForComodification(); // 检查是否有并发修改异常
        return cursor != myArrayList.size(); // 当指针不等于 ArrayList 的大小时，还有下一个元素
    }

    // 将指针移动到下一个元素
    @Override
    public void next() {
        checkForComodification(); // 检查是否有并发修改异常
        cursor++;
    }

    // 获取当前指向的元素
    @Override
    public E currentItem() {
        checkForComodification(); // 检查是否有并发修改异常
        if (cursor >= myArrayList.size()) { // 如果指针超出范围，抛出异常
            throw new NoSuchElementException();
        }
        return myArrayList.get(cursor); // 返回当前指向的元素
    }

    private void checkForComodification() {
        if (myArrayList.getModCount() != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}