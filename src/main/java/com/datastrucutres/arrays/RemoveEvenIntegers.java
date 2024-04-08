package com.datastrucutres.arrays;

public class RemoveEvenIntegers {

    public static Integer[] removeEven(Integer[] arr){
//        for(int i =0 ;i<arr.length;i++){
//            if((arr[i] %2) == 0)
//                arr[i] =0;
//        }
//        return arr;

        int oddCount =0;

        for(Integer element : arr){
            if((element % 2) != 0)
                oddCount++;
        }

        Integer[] res = new Integer[oddCount];
        int index =0;
        for(int i=0;i<arr.length;i++){
            if((arr[i] % 2) !=0){
                res[index] = arr[i];
                index++;
            }
        }
        return res;
    }
    public static <T> void printAnyArray(T[] array){
        for(T element : array){
            System.out.println(element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {3,2,4,7,10,6,5};
        Integer[] ints = removeEven(arr);

        printAnyArray(ints);
    }
}
