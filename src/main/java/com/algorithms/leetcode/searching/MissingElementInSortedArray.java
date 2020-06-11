package com.algorithms.leetcode.searching;

/**
 * 1060. Missing Element in Sorted Array
 * https://leetcode.com/problems/missing-element-in-sorted-array/
 */
public class MissingElementInSortedArray {

    public int missingElement(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int missingOnLeft = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            missingOnLeft = nums[mid] - (nums[0] + mid);
            if(missingOnLeft < k ){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return nums[0] + end + k;
    }
}
