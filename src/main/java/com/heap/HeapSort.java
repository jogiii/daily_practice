package com.heap;

public class HeapSort {

    public static void heapSort(int[] arr){

        int n = arr.length;

        /* Why n / 2 - 1 is the Last Internal Node?
In a binary heap:

A node at index i has:

Left child at 2i + 1

Right child at 2i + 2

So, all nodes with index ≥ n/2 are leaf nodes — they don’t have children. */
        for(int i=n/2-1;i >= 0;i--){
            heapifyArray(arr, n, i);
        }

        // Step 2: Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);          // Move current root to end
            heapifyArray(arr, i, 0);       // Heapify reduced heap
        }
    }

    public static void heapifyArray(int[] arr,int n, int i){

        while(true){
            int largest =i;
            int left = i*2+1;
            int right = i*2+2;



            if((left<n) && (arr[left] >arr[largest])){
                largest = left;
            }

            if((right <n)&& (arr[right] > arr[largest])){
                largest = right;
            }

            if(largest == i){
                break;
            }

            swap(arr, i, largest);
            i =largest; //// move down to child and repeat

        }

        

    }

    public static void swap(int[] arr, int largest, int i){
        int temp = arr[largest];
        arr[largest] = arr[i];
        arr[i] = temp;
    }

     // Main method for testing
     public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 2};

        System.out.println("Original Array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    // Helper method to print array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
