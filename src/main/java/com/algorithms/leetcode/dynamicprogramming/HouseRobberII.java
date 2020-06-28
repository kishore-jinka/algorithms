package com.algorithms.leetcode.dynamicprogramming;

/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(nums[2], Math.max(nums[0], nums[1]));
        if(nums.length == 4) return Math.max(nums[0] + nums[2], nums[1] + nums[3]);

        //first house is robbed;
        int[] nums1 = new int[nums.length - 3];
        for(int i=2; i<nums.length -1; i++) nums1[i-2] = nums[i];
        int[] dp1 = new int[nums1.length + 1];
        dp1[0] = 0;
        dp1[1] = nums1[0];
        for(int i=2; i<=nums1.length; i++){
            int value1 = nums1[i-1] + dp1[i-2];
            int value2 = nums1[i-2];
            if(i>=3) value2 += dp1[i-3];
            dp1[i] = Math.max(value1, value2);
        }

        //first house is not robbed;
        int[] nums2 = new int[nums.length-1];
        for(int i=1; i<nums.length; i++) nums2[i-1] = nums[i];
        int[] dp2 = new int[nums2.length + 1];
        dp2[0] = 0;
        dp2[1] = nums2[0];
        for(int i=2; i<=nums2.length; i++){
            int value1 = nums2[i-1] + dp2[i-2];
            int value2 = nums2[i-2];
            if(i>=3) value2 += dp2[i-3];
            dp2[i] = Math.max(value1, value2);
        }
        return Math.max(nums[0] + dp1[nums1.length], dp2[nums2.length]);


    }
}
