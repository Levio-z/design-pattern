package com.divine.code.iterator;


public class SnapArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int actualSize; // 不包含标记删除元素的实际大小
    private int totalSize; // 包含标记删除元素的总大小

    private Object[] elements; // 存储元素的数组
    private long[] addTimestamps; // 元素添加的时间戳
    private long[] delTimestamps; // 元素删除的时间戳

    public SnapArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.addTimestamps = new long[DEFAULT_CAPACITY];
        this.delTimestamps = new long[DEFAULT_CAPACITY];
        this.totalSize = 0;
        this.actualSize = 0;
    }

    @Override
    public void add(E obj) {
        ensureCapacity();
        elements[totalSize] = obj;
        addTimestamps[totalSize] = System.currentTimeMillis();
        delTimestamps[totalSize] = Long.MAX_VALUE;
        totalSize++;
        actualSize++;
    }

    @Override
    public Iterator iterator() {
        return new SnapIterator(this);
    }

    @Override
    public int size() {
        return totalSize;
    }

    @Override
    public E remove(int i) {
        delTimestamps[i] = System.currentTimeMillis();
        actualSize--;
        return (E)elements[i];
    }

    public void remove(E obj) {
        for (int i = 0; i < totalSize; ++i) {
            if (elements[i].equals(obj)) {
                delTimestamps[i] = System.currentTimeMillis();
                actualSize--;
            }
        }
    }

    public int actualSize() {
        return this.actualSize;
    }

    public int totalSize() {
        return this.totalSize;
    }

    public E get(int i) {
        if (i >= totalSize) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[i];
    }

    public long getAddTimestamp(int i) {
        if (i >= totalSize) {
            throw new IndexOutOfBoundsException();
        }
        return addTimestamps[i];
    }

    public long getDelTimestamp(int i) {
        if (i >= totalSize) {
            throw new IndexOutOfBoundsException();
        }
        return delTimestamps[i];
    }

    private void ensureCapacity() {
        if (totalSize == elements.length) {
            int newCapacity = elements.length * 2;
            elements = java.util.Arrays.copyOf(elements, newCapacity);
            addTimestamps = java.util.Arrays.copyOf(addTimestamps, newCapacity);
            delTimestamps = java.util.Arrays.copyOf(delTimestamps, newCapacity);
        }
    }
}