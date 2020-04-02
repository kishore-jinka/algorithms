package com.algorithms.leetcode.arrays;

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        int result = nums[0];
        for(int i=1; i<nums.length; i++){ //start the index from 1
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args){
        int[] array = {4,1,2,1,2};
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(array));
    }
}
