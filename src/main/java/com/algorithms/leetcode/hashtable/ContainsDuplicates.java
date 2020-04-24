package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 *  217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 * https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1112/
 */
public class ContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2) return false;
        Map<Integer, Integer> map = new HashMap();
        for(int i : nums){
            if(map.get(i) == null){
                map.put(i,1);
            }else return true;
        }
        return false;
    }
}
