package com.greedy;

import java.util.Arrays;

public class FractionalKnapsack {

    static class Item {
        int profit, weight;
        double ratio;

        Item(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
            this.ratio = (double) profit / weight;
        }
    }

    public static void main(String[] args) {
        int[] profits = {10, 5, 15, 7, 6, 18, 3};
        int[] weights = {2, 3, 5, 7, 1, 4, 1};
        int capacity = 15;

        int n = profits.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(profits[i], weights[i]);
        }

        // Sort by descending profit/weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // Take full item
                totalProfit += item.profit;
                currentWeight += item.weight;
            } else {
                // Take fractional part
                int remaining = capacity - currentWeight;
                totalProfit += item.ratio * remaining;
                break;
            }
        }

        System.out.printf("Maximum Profit (Fractional Knapsack): %.2f\n", totalProfit);
    }

    }
