package com.algorithms.leetcode.searching;

/**
 * 81. Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0)  return false;
        int start = 0;
        int end = nums.length - 1;
        while(nums[start] == nums[end] && start<end){
            start++;
        }
        if(start == end && nums[start] == target) return true;
        boolean inLowerZone = target > nums[end];
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return true;
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
        return false;
    }
}
