package com.algorithms.leetcode.slidingwindow;

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 * //TODO:INCOMPLETE
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return nums;
        int[] maxWindow = new int[nums.length-k+1];
        int zeroIndexMax = Integer.MIN_VALUE;
        for(int i=0; i<k; i++){
            if(nums[i] > zeroIndexMax) zeroIndexMax = nums[i];
        }
        maxWindow[0] = zeroIndexMax;
        for(int i=k; i<nums.length; i++){
            if(maxWindow[i-k]>nums[i]){
                maxWindow[i-k+1] = maxWindow[i-k];
            }else{
                maxWindow[i-k+1] = nums[i];
            }
        }
        return maxWindow;
    }

    public static void main(String[] args){
        //nums = [1,3,-1,-3,5,3,6,7], and k = 3
        //int[] nums = {1,3,-1,-3,5,3,6,7};
        //int k = 3;
        int[] nums = {1, -1};
        int k = 1;
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        for(int i:slidingWindowMaximum.maxSlidingWindow(nums,k)) {
            System.out.println(i);
        }
    }
}
