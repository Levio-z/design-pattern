package com.divine.code.iterator;

import java.util.NoSuchElementException;

public class SnapIterator<E> implements Iterator<E>{
    private int cursor; // 当前指针位置
    private SnapArrayList<E> myArrayList; // 存储元素的 ArrayList
    private long timeStamp; // 用于记录时间戳

    // 构造方法，初始化指针和 ArrayList
    public SnapIterator(SnapArrayList<E> myArrayList) {
        this.myArrayList = myArrayList;
        this.timeStamp =  System.currentTimeMillis();
        this.cursor = -1;
        this.cursor=tryNext();
    }

    // 判断是否有下一个元素
    @Override
    public boolean hasNext() {
        // 兼容删除当前游标的场景
        return cursor+1 != myArrayList.size() &&(myArrayList.getDelTimestamp(cursor+1) > timeStamp &&
                myArrayList.getAddTimestamp(cursor+1) <= timeStamp); // 当指针不等于 ArrayList 的大小时，还有下一个元素
    }

    // 将指针移动到下一个元素
    @Override
    public void next() {
        int oldCursor = cursor;
        tryNext();
        if (cursor >= myArrayList.size()) { // 如果指针超出范围，抛出异常
            cursor = oldCursor; // 恢复到上一个有效位置
            throw new NoSuchElementException();
        }
    }
    private int  tryNext() {
        // 尝试找到下一个元素的当前坐标
        while(cursor+1<= myArrayList.size()-1&&(myArrayList.getDelTimestamp(cursor+1) <= timeStamp ||
                myArrayList.getAddTimestamp(cursor+1) > timeStamp)) { // 检查当前元素是否被删除或添加
            cursor++; // 如果没有被删除或添加，移动指针到下一个元素
        }
        cursor++;
        return cursor;
    }

    // 获取当前指向的元素
    @Override
    public E currentItem() {
        if (cursor >= myArrayList.size()) { // 如果指针超出范围，抛出异常
            throw new NoSuchElementException();
        }
        return myArrayList.get(cursor); // 返回当前指向的元素
    }

}
