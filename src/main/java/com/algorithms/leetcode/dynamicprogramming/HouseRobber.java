package com.algorithms.leetcode.dynamicprogramming;

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2; i<=nums.length; i++){
            int value1 = nums[i-1] + dp[i-2];
            int value2 = nums[i-2];
            if(i>=3) value2 += dp[i-3];
            dp[i] = Math.max(value1, value2);
        }
        return dp[nums.length];
    }
}
