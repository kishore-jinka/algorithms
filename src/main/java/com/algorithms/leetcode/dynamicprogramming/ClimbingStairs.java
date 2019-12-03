package com.algorithms.leetcode.dynamicprogramming;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 */
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
