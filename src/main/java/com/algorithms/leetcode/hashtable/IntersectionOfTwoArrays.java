package com.algorithms.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1105/
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap();
        for(int i : nums1){
            if(map.get(i) == null) map.put(i, 1);
        }
        List<Integer> list = new ArrayList();
        for(int i : nums2){
            if(map.get(i) != null && map.get(i) == 1){
                list.add(i);
                map.put(i, map.get(i) + 1);
            }
        }
        int[] toReturn = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            toReturn[i] = list.get(i);
        }
        return toReturn;
    }
}
