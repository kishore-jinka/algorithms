package com.algorithms.leetcode.arrays;

/**
 * 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 * https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3238/
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
                if(maxCount < count) maxCount = count;
            }
            if(nums[i] == 0 && count != 0){
                count = 0;
            }
        }
        return maxCount;
    }

}
