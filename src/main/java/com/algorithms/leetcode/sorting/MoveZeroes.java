package com.algorithms.leetcode.sorting;

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        int orangeIndex = -1;
        for(int greenIndex = 0; greenIndex < nums.length; greenIndex ++){
            if(nums[greenIndex] != 0){
                orangeIndex ++;
                int temp = nums[greenIndex];
                nums[greenIndex] = nums[orangeIndex];
                nums[orangeIndex] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        for(int num : nums)
            System.out.println(num);
    }


}
