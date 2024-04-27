package com.extra;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpressions {

    public static void main(String[] args) {


        String multiLineString = """
                this is multiline String 
                this cann help in mutiple ways
                """;

        System.out.println(multiLineString);
        int days = 0;
        Month month = Month.APRIL;

        switch (month){
            case  JANUARY, FEBRUARY, MARCH :
                days = 31;
                break;

            case APRIL:
                days =28;
                break;
            default:
                throw new IllegalArgumentException();

        }
    }


}
