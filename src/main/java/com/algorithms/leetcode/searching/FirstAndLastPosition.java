package com.algorithms.leetcode.searching;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] positions = {-1, -1};
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= target){
                end = mid - 1;
            } else { //<
                start = mid + 1;
            }
        }
        if (start == nums.length || nums[start] != target) return positions;
        int first = start;
        positions[0] = first;
        end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid - 1;
            } else { //<=
                start = mid + 1;
            }
        }
        positions[1] = end;
        return positions;
    }

    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        FirstAndLastPosition firstAndLastPosition = new FirstAndLastPosition();
        int[] range = firstAndLastPosition.searchRange(nums, target);
        System.out.println(range[0] + "," + range[1]);
    }
}
