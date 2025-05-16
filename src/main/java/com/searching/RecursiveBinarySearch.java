package com.searching;

public class RecursiveBinarySearch {

    public int search(int[] arr, int target, int low, int high){
        //if length of list is 1

        if(low == high){
            if(arr[low] == target){
                return low;
            }
            else{
                return -1;
            }
        }else{
            int mid = low+high/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                return search(arr, target, low, mid - 1);
            }
            else{
                return search(arr, target, mid + 1, high);
            }
        }
    }

    public static void main(String[] args) {
        RecursiveBinarySearch binarySearch = new RecursiveBinarySearch();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = binarySearch.search(arr, target, 0, arr.length - 1);
        if(result == -1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at index: " + result);
        }
    }
}
