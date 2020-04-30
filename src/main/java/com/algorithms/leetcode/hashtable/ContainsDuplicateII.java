package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/
 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1121/
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 1) return false;
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            Integer value = map.get(nums[i]);
            if(value != null && i-value <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
