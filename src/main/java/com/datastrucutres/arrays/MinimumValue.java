package com.datastrucutres.arrays;

public class MinimumValue {

    public static int findMinimumValue(int[] arr){
       int min =0;

       for(int i=1;i<arr.length;i++){
           if(arr[min] > arr[i])
               min = i;
       }
        return arr[min];
    }

    public static void main(String[] args) {
        int[] arr = {2,11,1,10,7,8};
        int minimumValue = findMinimumValue(arr);
        System.out.println(minimumValue);
    }
}
