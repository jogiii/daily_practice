package com.searching;

public class BinarySearch {


    public int Search(int arr[], int target){

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low+high/2;

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;


//create a binary search method that takes an array and a target value as inp
    }

public void binarySearch(int arr[], int target) {
        int result = Search(arr, target);
        if(result == -1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at index: " + result);
        }
    }


    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = binarySearch.Search(arr, target);
        if(result == -1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at index: " + result);
        }
    }



}
