package com.string;

import java.util.HashMap;
import java.util.Map;

public class CountFrequency {

    public static void main(String[] args) {
        String abc = "aaaabbbbccccdddeeefffaaa";

        CountFrequency cf = new CountFrequency();
       Map<Character, Integer> m = cf.countFrequency(abc);
       
       for(Character key : m.keySet()){
            System.out.println("key :"+key+" value :"+m.get(key));
       }


    }

    public Map<Character, Integer> countFrequency(String str){
       
        Map<Character, Integer> countMap = new HashMap<>();
        for(char ch: str.toCharArray()){
            countMap.put(ch, countMap.getOrDefault(ch, 0)+1); // getOrDefault return if nothing is there , then 0 +1 else value +1
        }

        return countMap;

        
    }

}
