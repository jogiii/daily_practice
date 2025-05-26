package com.sorting.merge;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 5, 2, 7, 4, 1};

        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] arrA = new int[n1];
        int[] arrB = new int[n2];

        for (int i = 0; i < n1; i++) {
            arrA[i] = arr[low + i];
        }

        for (int j = 0; j < n2; j++) {
            arrB[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (arrA[i] <= arrB[j]) {
                arr[k++] = arrA[i++];
            } else {
                arr[k++] = arrB[j++];
            }
        }

        while (i < n1) {
            arr[k++] = arrA[i++];
        }

        while (j < n2) {
            arr[k++] = arrB[j++];
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

   
}
