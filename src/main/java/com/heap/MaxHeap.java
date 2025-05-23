package com.heap;

public class MaxHeap {

    int[] heap;
    int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return heap[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            int[] newHeap = new int[capacity * 2];
            System.arraycopy(heap, 0, newHeap, 0, capacity);
            heap = newHeap;
            capacity *= 2;
        }
    }

    public void insert(int value) {
        ensureExtraCapacity();
        heap[size] = value;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) < heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int maxValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return maxValue;
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

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }


}
