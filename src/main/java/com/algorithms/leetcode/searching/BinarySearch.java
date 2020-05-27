package com.algorithms.leetcode.searching;

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return searchRecursive(0, nums.length - 1, nums, target);
    }

    private int searchRecursive(int start, int end, int[] nums, int target){
        if(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) return searchRecursive(start, mid-1, nums, target);
            return searchRecursive(mid+1, end, nums, target);
        }
        return -1;
    }
}
