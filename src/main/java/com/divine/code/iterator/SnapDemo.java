package com.divine.code.iterator;

public class SnapDemo {
    public static void main(String[] args) {
        // 创建一个 ArrayList 并添加元素
        SnapArrayList<String> names = new SnapArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");

        // 创建 ArrayIterator 对象
        Iterator<String> iterator = names.iterator();
        names.remove(0);
        Iterator<String> iterator2 = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.currentItem());
            iterator.next();
        }
        System.out.println(iterator.currentItem());

        while (iterator2.hasNext()) {
            System.out.println(iterator2.currentItem());
            iterator2.next();
        }
        System.out.println(iterator2.currentItem());

        // 创建一个 ArrayList 并添加元素
        SnapArrayList<String> names3 = new SnapArrayList<>();
        Iterator<String> iterator3 = names3.iterator();
        try {
            System.out.println(iterator3.currentItem());
        }catch (Exception e) {
            System.out.println("迭代器已失效");
        }
        names3.add("xzg");
        System.out.println(iterator2.currentItem());

    }
}