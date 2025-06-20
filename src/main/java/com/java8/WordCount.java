package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCount {



    public static void main(String[] args) {
        String[] arr = {"apple","mango","pineapple","pepsi","apple","mango","pineapple","pepsi","apple","mango","pineapple","pepsi","apple","mango","first","second"};

        Map<String, Long> collect = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
       System.out.println(collect);


       // find duplicate entries in list with count


       List<String> collect2 = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e->e.getValue() > 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());


            System.out.println(collect2);


    // find first non-repeating character


    String a = "ilovejavatechie";

    String key = Arrays.stream(a.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                                .entrySet()
                                .stream()
                                .filter(e->e.getValue()==1)
                                .findFirst().get().getKey();



                System.out.println(key);


    // find second highest number in array

    int[] numbers = {5,9,11,2,8,21,1};

    Integer integer = Arrays.stream(numbers).boxed()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst().get();

            System.out.println(integer);

    String [] strArray = {"java","techie","springboot","micorservices"};

    String longestWord = Arrays.stream(strArray)
            .reduce((word1,word2) -> word1.length()>word2.length()?word1:word2)
            .get();

            System.out.println(longestWord);
            
            
       

    }

}
