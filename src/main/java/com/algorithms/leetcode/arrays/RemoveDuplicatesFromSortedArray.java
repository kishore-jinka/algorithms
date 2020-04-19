package com.algorithms.leetcode.arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * https://leetcode.com/explore/featured/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int orangePointer = 0;
        int greenPointer = 1;
        while(greenPointer < nums.length){
            if(nums[greenPointer] > nums[greenPointer - 1]){
                orangePointer = orangePointer + 1;
                nums[orangePointer] = nums[greenPointer];
            }
            greenPointer = greenPointer + 1;
        }
        return orangePointer + 1;
    }

    public static void main(String[] args){
        //int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {1,1,2};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
        for(int i : nums){
            System.out.println(i);
        }
    }
}
