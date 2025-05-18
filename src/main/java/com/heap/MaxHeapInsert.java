package com.heap;

public class MaxHeapInsert {



    private int size;
    private int capacity;
    private int[] heap;


    public MaxHeapInsert(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    public void insert(int value) {
        ensureExtraCapacity();
        heap[size] = value;
        size++;
        heapifyUp();
    }


    public void ensureExtraCapacity() {
        if(size == capacity) {
           int[] newHeap = new int[capacity * 2];
           System.arraycopy(heap, 0, newHeap, 0, capacity);
           heap = newHeap;
           capacity *= 2;
        }
    }

    public void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && parent(index)<heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }
    private int parent(int index) {
        return heap[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }
}
