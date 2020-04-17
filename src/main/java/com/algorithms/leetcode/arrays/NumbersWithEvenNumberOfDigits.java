package com.algorithms.leetcode.arrays;

/**
 * 1295. Find Numbers with Even Number of Digits
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
 */
public class NumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int totalDigits = 0;
            while(nums[i] != 0){
                nums[i] = nums[i]/10;
                totalDigits++;
            }
            if(totalDigits%2 == 0) count++;
        }
        return count;
    }

}
