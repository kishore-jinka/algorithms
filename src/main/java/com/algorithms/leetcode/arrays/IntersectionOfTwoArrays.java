package com.algorithms.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/submissions/
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        for(int i:nums1){
            map.put(i,1);
        }
        int total = 0;
        for(int i:nums2){
            if(map.get(i) != null && map.get(i) != 2){
                map.put(i, 2);
                total = total+1;
            }
        }
        int[] toReturn = new int[total];
        int index = 0;
        for(Integer i : map.keySet()){
            if(map.get(i) == 2) toReturn[index++] = i;
        }
        return toReturn;
    }
}
