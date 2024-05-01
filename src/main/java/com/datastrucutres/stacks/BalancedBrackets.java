package com.datastrucutres.stacks;

import java.util.Stack;

public class BalancedBrackets {

    public Boolean checkValidity(String exp){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<exp.length();i++){

            char x = exp.charAt(i);
            if(x == '(' || x == '{' || x == '['){
                stack.push(x);
                continue;
            }

            if(stack.isEmpty())
                return false;

            char check;

            switch (x){
                case ')':
                    check = stack.pop();
                    if(check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if(check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = stack.pop();
                    if(check == '(' || check == '{')
                        return false;
                    break;
            }

        }





        return (stack.isEmpty());
    }

    public static void main(String[] args)
    {


        BalancedBrackets balancedBrackets = new BalancedBrackets();
        String expr = "([{}])";

        // Function call
        if (balancedBrackets.checkValidity(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
