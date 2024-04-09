package com.datastrucutres.arrays;

public class SecondMaxValue {

    public static int findSecondMaxValue(int[] arr){
        int max = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;


        for(int num : arr){
            if(num > max){
                sMax = max;
                max =num;

            }
            else if((num > sMax) && (num != max)){
                sMax = num;
            }


        }
        return sMax;
    }

    public static void main(String[] args) {
        int[] arr =  {13,34,2,34,33};
        int secondMaxValue = findSecondMaxValue(arr);
        System.out.println(secondMaxValue);

    }
}
