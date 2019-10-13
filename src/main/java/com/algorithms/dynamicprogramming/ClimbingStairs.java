package com.algorithms.dynamicprogramming;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int steps[] = {2,3};
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int step : steps){
                if(i == step) count += 1;
                if(i > step && dp[i-step] > 0) count += dp[i-step];
            }
            dp[i] = count;
        }
        return dp[n];
    }

    public static void main(String[] args){
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(10));
    }
}
/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
