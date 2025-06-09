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

    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    private int getParentIndex(int index){
        return (index-1)/2;
    }

    private int parent(int index){
        return heap[getParentIndex(index)];
    }

    private void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public int delete(){
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int maxValue = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapifyDown();

        return maxValue;


    }


    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int largerChildIndex = getLeftChiltIndex(index);
            if(hasRightChild(index) && getRightChildIndex(index) >largerChildIndex){
                largerChildIndex = getRightChildIndex(index);
            }
            if(heap[index] > largerChildIndex){
                break;
            }else{
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }








}
