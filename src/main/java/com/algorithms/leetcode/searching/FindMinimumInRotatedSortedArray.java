package com.algorithms.leetcode.searching;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[nums.length - 1]){
                start = mid + 1;
            }else{
                end = mid - 1;
             }
        }
        return nums[start];
    }
}
