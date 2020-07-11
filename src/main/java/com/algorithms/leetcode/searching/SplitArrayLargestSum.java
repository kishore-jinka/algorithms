package com.algorithms.leetcode.searching;

/**
 * 410. Split Array Largest Sum
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        for(int i=0; i<nums.length; i++){
            end = end + nums[i];
            if(start < nums[i]) start = nums[i];
        }
        //start = largest element
        //end = sum of all elements
        while(start<=end){
            int mid = start + (end - start)/2;
            int numberOfSubArrays = 1;
            int sum = 0;
            for(int i=0; i<nums.length; i++){
                sum = sum + nums[i];
                if(sum > mid){
                    sum = nums[i];
                    numberOfSubArrays = numberOfSubArrays + 1;
                }
            }
            if(numberOfSubArrays > m){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}
