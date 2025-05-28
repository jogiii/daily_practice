package com.greedy;

import java.util.Arrays;

public class JobSequencing {

//Jobs = [(a,2,100), (c,2,27), (d,1,25), (b,1,19),(e,3,15)]
    public static int[] jobScheduling(Job[] jobs){
        //step 1: sort the jobs decending by their profit

        Arrays.sort(jobs, (a,b) -> Integer.compare(b.profit ,a.profit));


        // step 2 : find the maximum deadline to size the time slots array
        int maxDeadline = 0;

        for(Job job : jobs){
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Step 3: Time slots array (1-based indexing)
        boolean[] slots = new boolean[maxDeadline+1];
        int jobCount =0, totalProfit =0;

        // Step 4: Try to assign each job to the latest free slot ≤ deadline
        for(Job job : jobs){
            for(int i=job.deadline;i>0;i--){
                if(!slots[i]){
                    slots[i] = true;
                    jobCount++;
                    totalProfit += job.profit;
                    break;

                }
            }
        }
        return new int[]{jobCount, totalProfit};
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        };

        int[] result = jobScheduling(jobs);
        System.out.println("Max Jobs Done: " + result[0]);
        System.out.println("Total Profit: " + result[1]);
    }

}
