package com.algorithms.leetcode.arrays;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int maxSum = nums[0];
        int sumSoFar = nums[0];
        for(int i=1; i<nums.length; i++){
            if(sumSoFar < 0){
                sumSoFar = nums[i];
            }else{
                sumSoFar = sumSoFar + nums[i];
            }
            if(sumSoFar > maxSum){
                maxSum = sumSoFar;
            }
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(nums));
    }
}
