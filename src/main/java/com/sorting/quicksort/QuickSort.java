package com.sorting.quicksort;

public class QuickSort {


    public static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int p = partition(arr, l, h);
            quickSort(arr, l, p);
            quickSort(arr, p + 1, h);
        }
    }

    public static int partition(int[] arr,int l, int h){
        int pivot =arr[l];
        int i=l-1; //We want to start i just before the first valid index (l) because we increment i immediately in the do { i++; } while (...) loop.
        int j=h+1; //Similarly, j starts just after the last valid index (h) because we decrement j immediately in the do { j--; } while (...) loop.

while(  true){
        do{
            i++;
        }while(arr[i] < pivot);
        do{
            j--;
        }while(arr[j]> pivot);
        if(i>=j){
            return j;
        }
        swap(arr, i, j);
    }

}


private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

public static void main(String[] args) {
    int[] arr = {10, 3, 8, 15, 6, 12, 2, 7};

    System.out.println("Original Array:");
    printArray(arr);

    quickSort(arr, 0, arr.length - 1);

    System.out.println("Sorted Array:");
    printArray(arr);
}

private static void printArray(int[] arr) {
    for (int value : arr) {
        System.out.print(value + " ");
    }
    System.out.println();
}

}
