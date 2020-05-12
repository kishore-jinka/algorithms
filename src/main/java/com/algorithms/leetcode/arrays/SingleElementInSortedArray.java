package com.algorithms.leetcode.arrays;

/**
 * 540. Single Element in a Sorted Array
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
 * This is similar to 136. Single Number https://leetcode.com/problems/single-number/
 */
public class SingleElementInSortedArray {
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
        SingleElementInSortedArray sn = new SingleElementInSortedArray();
        System.out.println(sn.singleNumber(array));
    }
}
