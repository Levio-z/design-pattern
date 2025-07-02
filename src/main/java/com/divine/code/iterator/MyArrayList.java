package com.divine.code.iterator;

public class MyArrayList<E> implements List<E>{

    private java.util.ArrayList<E> arrayList;
    private int modCount = 0;

    public Iterator iterator() {
        return new ArrayIterator(this);
    }

    @Override
    public void add(E e) {
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
        }
        this.modCount++;
        arrayList.add(e);
    }

    @Override
    public E get(int i) {
        return arrayList.get(i);
    }

    @Override
    public int size() {
        if (arrayList == null) {
            return 0; // 如果 ArrayList 为空，返回 0
        }
        return arrayList.size();
    }

    @Override
    public E remove(int i) {
        this.modCount++;
        return arrayList.remove(i);
    }

    public int getModCount() {
        return modCount;
    }

}
