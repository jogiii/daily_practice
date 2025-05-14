package com.sorting;

public class QuickSort {


    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low,high);
            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr, i+1,high);
        return i+1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper to print array
    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        int[] array = {6, 3, 9,10,11, 5, 2, 8};
        System.out.println("Before Sorting:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("After Sorting:");
        printArray(array);
    }
}
