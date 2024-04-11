package com.datastrucutres.arrays;

public class Palindrome {

    public static Boolean isPalindrome(String a){
        char[] charArray = a.toCharArray();
        int start =0;
        int end = charArray.length-1;

        while(start < end){
            if(charArray[start] !=charArray[end]){
                return false;
            }

            start++;
            end--;

        }
        return true;
    }

    public static void main(String[] args) {
        String a = "that";
        System.out.println(isPalindrome(a));
    }
}
