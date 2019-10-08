package com.algorithms.dynamicprogramming;

public class MinimumCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0) return 0;
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        for(int i=2; i<cost.length; i++){
            dp[i] = cost[i-1] + Math.min(dp[i-1], dp[i-2]);
        }
        dp[cost.length] = Math.min(dp[cost.length-1], cost[cost.length-1] + dp[cost.length-2]);
        return dp[cost.length];
    }

    public static void main(String[] args){
        //int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost = {0, 0, 0, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
