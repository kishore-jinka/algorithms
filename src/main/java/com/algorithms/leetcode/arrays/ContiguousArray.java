package com.algorithms.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 * https://leetcode.com/problems/contiguous-array/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if(nums.length == 0) return 0;
        int maxLength = 0;

        //1. calculate sum so far (take 0 as -1 and 1 as 1)
        int[] sumSoFar = new int[nums.length];
        if(nums[0] == 0){
            sumSoFar[0] = -1;
        }else{
            sumSoFar[0] = 1;
        }
        for(int i=1; i<nums.length; i++){
            if(nums[i] == 0){
                sumSoFar[i] = sumSoFar[i-1] - 1;
            }else{
                sumSoFar[i] = sumSoFar[i-1] + 1;
            }
        }

        //2. get the first index of each sum so far
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<sumSoFar.length; i++){
            Integer index = map.get(sumSoFar[i]);
            if(index == null){
                map.put(sumSoFar[i], i);
            }
        }

        //3. calculate max length
        for(int i=0; i<sumSoFar.length; i++){
            if(sumSoFar[i] != 0){
                int diff = i - map.get(sumSoFar[i]);
                if(diff > maxLength) maxLength = diff;
            }else{
                maxLength = i + 1;
            }
        }

        return maxLength;
    }

    public static void main(String[] args){
        //int[] nums = {1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,0,1,1,0,1,1,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,1,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,0,1,1,0,0,0,1,0,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,0,1,0,0,0,0};
        //int[] nums = {0,1};
        //int[] nums = {0,1,0};
        int[] nums = {0,1,0,1};
        ContiguousArray contiguousArray = new ContiguousArray();
        System.out.println(contiguousArray.findMaxLength(nums));
    }

}