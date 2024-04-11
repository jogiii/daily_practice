package com.datastrucutres.arrays;

public class FindMissingNumber {

    public static int missingNumber(int [] arr){

        int res = (arr.length +1)* (arr.length+2)/2;
        int sum =0;
        for(int element : arr){
            sum = sum+element;
        }
        return res-sum;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,8,6,3,7};
        System.out.println(missingNumber(arr));
    }
}
