package com.algo;

public class KMPAlgo {

    private static int[] buildLPS(String pattern) {

        int m =pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;



        while(i < m){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len !=0){
                    len = lps[len-1]; //sending it back until the string was matching
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }


    public static void KMPSearch(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while(i < n){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }

            if(j == m){
                System.out.println("Match found from index"+(i-j)+" to index"+i);
                j = lps[j-1]; //continue searching
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }

            }
        }

    }


    public static void main(String[] args) {
        String text = "AAABAAABAAAB";
        String pattern = "AAAB";

        KMPSearch(text, pattern);
    }

}
