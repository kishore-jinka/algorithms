package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length <= 2) return nums[0];
        Map<Integer, Integer> map = new HashMap();
        int maxCount = 0;
        int majorityElement = nums[0];
        for(int i : nums){
            if(map.get(i) == null){
                map.put(i, 0);
            }
            int newValue = map.get(i) + 1;
            map.put(i, newValue);
            if(newValue > maxCount){
                maxCount = newValue;
                majorityElement = i;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args){
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(nums));
    }
}
