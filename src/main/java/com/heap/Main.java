package com.heap;

public class Main {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(15);

        System.out.println("Max Heap: ");
        for (int i = 0; i < maxHeap.size; i++) {
            System.out.print(maxHeap.heap[i] + " ");
        }
        System.out.println();

        System.out.println("Max Element: " + maxHeap.peek());
        System.out.println("Removed Max Element: " + maxHeap.extractMax());
        System.out.println("Max Element after removal: " + maxHeap.peek());
    }
}
