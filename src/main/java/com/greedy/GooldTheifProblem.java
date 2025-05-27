package com.greedy;

import java.util.Arrays;

import com.greedy.FractionalKnapsack.Item;

public class GooldTheifProblem {

    static class GoldItem{
        int weight;
        int value;
        double ratio;

        GoldItem(int weight, int value){
            this.weight = weight;
            this.value = value;
            ratio = value/weight;

        }


    }



    public static void main(String[] args) {
        int capacity = 50;
        int[] weights = {10,20,30};
        int[] values = {60,100,120};

        int n = weights.length;


        GoldItem[] goldItems = new GoldItem[n];



        for(int i=0;i<n;i++){
            goldItems[i] = new GoldItem(weights[i], values[i]);
        }

        Arrays.sort(goldItems,(a,b) -> Double.compare(b.ratio,a.ratio) );

        double totalProfit =0.0;
        int currentWeight = 0;

        for(GoldItem items : goldItems){

            if(currentWeight+items.weight <capacity){
                currentWeight += items.weight;
                totalProfit += items.value;
            }else{
                int remainingCapacity =capacity-items.weight;
                totalProfit += remainingCapacity*items.ratio;
                break;
            }


        }

        System.out.printf("Maximum Profit (Fractional Knapsack): %.2f\n", totalProfit);
        
    }

}
