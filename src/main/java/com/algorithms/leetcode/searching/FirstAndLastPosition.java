package com.algorithms.leetcode.searching;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int position = getPosition(nums, target);
        int[] toReturn = {-1, -1};
        if(position == -1) return toReturn;
        int frontIndex = position;
        int rearIndex = position;
        while(frontIndex >= 0 && target == nums[frontIndex]){
            frontIndex--;
        }
        while(rearIndex <= nums.length - 1 && target == nums[rearIndex]){
            rearIndex++;
        }
        toReturn[0] = frontIndex+1;
        toReturn[1] = rearIndex-1;
        return  toReturn;
    }

    private int getPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]) return mid;
            if(target < nums[mid]) end = mid - 1;
            if(target > nums[mid]) start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int target = 10;
        FirstAndLastPosition firstAndLastPosition = new FirstAndLastPosition();
        int[] range = firstAndLastPosition.searchRange(nums, target);
        System.out.println(range[0] + "," + range[1]);
    }
}
