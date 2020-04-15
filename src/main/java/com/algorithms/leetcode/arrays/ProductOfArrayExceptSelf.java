package com.algorithms.leetcode.arrays;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums;
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        int prefix = 1;
        prefixProduct[0] = 1;
        for(int i=1; i<nums.length; i++){
            prefix = prefix * nums[i-1];
            prefixProduct[i] =  prefix;
        }

        int suffix = 1;
        suffixProduct[nums.length-1] = 1;
        for(int i=nums.length - 2; i>=0; i--){
            suffix = suffix * nums[i+1];
            suffixProduct[i] =  suffix;
        }

        int[] selfLessProduct = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            selfLessProduct[i] = suffixProduct[i] * prefixProduct[i];
        }

        return selfLessProduct;
    }

    public static void main(String[] args){
        int[] input = {1,2,3,4};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] selfLessProducts = productOfArrayExceptSelf.productExceptSelf(input);
        for(int i: selfLessProducts){
            System.out.println(i);
        }
    }
}

/*
Input:  [1,2,3,4]
Output: [24,12,8,6]
 */