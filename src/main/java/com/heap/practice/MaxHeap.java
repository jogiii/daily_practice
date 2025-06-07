package com.heap.practice;

public class MaxHeap {

    int[] heap;
    private int capacity;
    int size;


    public MaxHeap(int capacity){

        this.capacity = capacity;
        heap = new int[capacity];
        this.size=0;
    }

    public void insert(int value){
        ensureExtraCapacity();
        heap[size]=value;
        size++;
        heapifyUp();
    }

    private void ensureExtraCapacity(){
        if(size == capacity){
            int[] newHeap = new int[capacity *2];
            System.arraycopy(heap, 0, newHeap, 0, capacity);
            heap = newHeap;
            capacity *= 2;
        }
    }

    private void heapifyUp(){
        int index = size-1;
        while(hasParent(index) && parent(index) < heap[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    public int getParentIndex(int index){
        return (index-1)/2;
    }

    public int parent(int index){
        return heap[getParentIndex(index)];
    }

    public void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }




}
