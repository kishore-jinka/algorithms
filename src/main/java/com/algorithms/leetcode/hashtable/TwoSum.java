package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 170. Two Sum III - Data structure design
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/submissions/
 * https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1179/
 */
public class TwoSum {

    Map<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap();
    }

    public void add(int number) {
        if(map.get(number) == null){
            map.put(number, 1);
        }else{
            map.put(number, map.get(number) + 1);
        }
    }

    public boolean find(int value) {
        Set<Integer> keySet = map.keySet();
        for(Integer i : keySet){
            if(value == 2*i && map.get(i) > 1){
                return true;
            }else if(value != 2*i && map.get(value - i) != null) {
                return true;
            }
        }
        return false;
    }
}
