package com.algorithms.leetcode.arrays;

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 * https://leetcode.com/explore/featured/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int orangePointer = nums.length;
        int greenPointer = nums.length-1;
        while(greenPointer>=0){
            if(nums[greenPointer] == val){
                orangePointer = orangePointer - 1;
                swap(nums, orangePointer, greenPointer);
            }
            greenPointer = greenPointer - 1;
        }
        return orangePointer;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
