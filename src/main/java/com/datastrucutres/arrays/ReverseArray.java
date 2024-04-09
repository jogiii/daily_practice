package com.datastrucutres.arrays;

public class ReverseArray {

    public static int [] revArray(int[] arr){
        int start =0;
        int end =arr.length-1;
        int temp =0;

        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start ++;
            end --;
        }


        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {2,11,5,10,7,8};

        int[] ints = revArray(arr);
        for(int e : ints){
            System.out.print(e);
            System.out.print(" ");
        }

    }
}
