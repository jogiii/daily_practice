package com.datastrucutres.arrays;

public class MoveAllZero {

    public static Integer[] moveZeros(Integer [] arr){
        int start =0;
        int end = arr.length-1;
        int temp;

        if(arr[end] == 0)
            end--;

        while(start < end){
            if(arr[start] ==0){
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start ++;
                end --;
            }

            if(start !=0)
                start++;
        }

        return arr;

    }

    public static Integer[] moveZeroInOrder(Integer[] arr){

       int index =0;
       int temp;

       for(int i=0;i<arr.length;i++){
           if(arr[i] !=0){
               temp = arr[i];
               arr[i] = arr[index];
               arr[index] = temp;

               index ++;
           }

        }

        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr = {0,1,0,4,0};

        Integer[] ints = moveZeroInOrder(arr);

        printArray.printAnyArray(ints);
    }
}
