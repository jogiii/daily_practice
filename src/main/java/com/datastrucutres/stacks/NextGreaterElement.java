package com.datastrucutres.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {


    int[] findNextGreaterElement(int[] arr){

        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){


            if(!stack.isEmpty()){
                while (!stack.isEmpty() && stack.peek() <arr[i]){
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

    return result;

    }

    public static void main(String[] args) {

        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElement.findNextGreaterElement(arr);
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}
