package com.algorithms.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return null;
        int[] keys = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(target-nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            Integer key = map.get(nums[i]);
            if(key != null && i != key){
                keys[0] = i;
                keys[1] = key;
                break;
            }
        }
        return keys;
    }
}
