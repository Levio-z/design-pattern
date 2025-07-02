package com.divine.code.iterator;

public class Demo {
    public static void main(String[] args) {
        // 创建一个 ArrayList 并添加元素
        MyArrayList<String> names = new MyArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");

        // 创建 ArrayIterator 对象
        Iterator<String> iterator = new ArrayIterator<>(names);
        // 封装迭代器创建细节，定义一个.iterator()方法
        iterator = names.iterator();
        // 遍历并打印元素
        while (iterator.hasNext()) {
            System.out.println(iterator.currentItem());
            iterator.next();
        }
        // 测试异常
        iterator = names.iterator();
        // 遍历并打印元素
        iterator.next();
        names.remove(0);
        iterator.next();
    }
}