package com.divine.code.algorithm.heap;

public class MaxHeap {
    private int[] heap;  // 存储堆的数组
    private int size;    // 当前堆中的元素数量
    private int capacity; // 堆的最大容量

    // 构造函数
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1];  // 堆数组，从索引1开始
    }

    // 插入数据到堆
    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full");
            return;
        }

        // 将新元素插入到堆的末尾
        size++;
        heap[size] = value;

        // 上滤操作，保持堆的性质
        int current = size;
        while (current > 1 && heap[current] > heap[current / 2]) {
            // 交换当前节点与父节点
            swap(current, current / 2);
            current = current / 2;
        }
    }
    public void removeMax() {
        if(size ==0) {
            System.out.println("Heap is empty");
             return;
        }
        heap[1]=heap[size];
        size--;
        heapify(heap,size,1);
    }

    private void heapify(int[] a,int n,int i) {
        while(true){
            int maxPos =i;
            if(i*2<=n && a[i]<a[i*2]) maxPos = i*2;
            if(i*2+1<=n && a[maxPos]<a[i*2+1]) maxPos = i*2+1;
            if(maxPos == i) break;
            swap(i,maxPos);
            i = maxPos;
        }
    }

    // 交换堆中两个元素的位置
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 打印堆的内容
    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        // 向堆中插入元素
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.removeMax();
        // 打印堆的内容
        maxHeap.printHeap(); // 输出：[10, 8, 3, 5]
    }
}
