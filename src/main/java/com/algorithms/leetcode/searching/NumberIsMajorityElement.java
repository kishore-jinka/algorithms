package com.algorithms.leetcode.searching;

/**
 * 1150. Check If a Number Is Majority Element in a Sorted Array
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
 */
public class NumberIsMajorityElement {
    public boolean isMajorityElement(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= target){
                end = mid - 1;
            } else { //<
                start = mid + 1;
            }
        }
        if (start == nums.length || nums[start] != target) return false;
        int first = start;
        end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid - 1;
            } else { //<=
                start = mid + 1;
            }
        }
        return (end-first) >= nums.length/2;
    }
}
