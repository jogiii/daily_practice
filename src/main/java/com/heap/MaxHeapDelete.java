package com.heap;

public class MaxHeapDelete {


    private int size;
    private int capacity;
    private int[] heap;

    public MaxHeapDelete(int capacity){
        this.capacity = capacity;
        this.size=0;
        heap = new int[capacity];
    }

    public int extractMax(){
        if(size == 0){
            throw new IllegalStateException("Heap is empty");
        }

        int maxValue = heap[0];
        heap[0] = heap[size -1];
        size--;
        heapifyDown();
        return maxValue;


    }
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }
    private int leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                largerChildIndex = getRightChildIndex(index);
            }
            if (heap[index] > heap[largerChildIndex]) {
                break;
            } else {
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    public int peek(){
        if(size == 0){
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

}
