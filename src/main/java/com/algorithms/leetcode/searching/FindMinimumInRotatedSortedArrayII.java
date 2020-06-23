package com.algorithms.leetcode.searching;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(nums[start] == nums[end] && start<end){
            start++;
        }
        if(start == end) return nums[start];
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
