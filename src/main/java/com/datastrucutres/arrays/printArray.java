package com.datastrucutres.arrays;


// print elements of any Type Array
public class printArray {

    public static <T> void printAnyArray(T[] array){
        for(T element : array){
            System.out.println(element);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5};
        printAnyArray(intArray);

    }
}
