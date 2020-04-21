package com.algorithms.leetcode.arrays;

/**
 * 487. Max Consecutive Ones II
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3230/
 */
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        boolean zeroFound = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                if(zeroFound == false) zeroFound = true;
                int count = countOnesOnBothSides(nums, i) + 1;
                if(count > max) max = count;
            }
        }
        if(!zeroFound){
            max = nums.length;
        }
        return max;
    }

    private int countOnesOnBothSides(int[] nums, int k){
        int total = 0;
        int i = k+1;
        while(i<nums.length && nums[i] == 1){
            total++;
            i++;
        }
        i = k-1;
        while(i>-1 && nums[i] == 1){
            total++;
            i--;
        }
        return total;
    }

}
