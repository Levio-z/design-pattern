package com.divine.code.iterator;

public interface List <E>{
    Iterator iterator();

    void add(E e);

    E get(int i);

    int size();
}
