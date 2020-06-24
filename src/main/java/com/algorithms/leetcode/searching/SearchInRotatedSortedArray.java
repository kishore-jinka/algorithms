package com.algorithms.leetcode.searching;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0)  return -1;
        int start = 0;
        int end = nums.length - 1;
        boolean inLowerZone = target > nums[end];
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] <= nums[nums.length - 1] && inLowerZone){
                end = mid - 1;
            }else if(nums[mid] > nums[nums.length - 1] && !inLowerZone){
                start = mid + 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
