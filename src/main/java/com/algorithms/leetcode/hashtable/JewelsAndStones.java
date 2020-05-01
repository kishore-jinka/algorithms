package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 771. Jewels And Stones
 * https://leetcode.com/problems/jewels-and-stones/
 * https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1136/
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if(J.length() == 0 || S.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap();
        for(Character c : J.toCharArray()){
            map.put(c, 0);
        }
        int total = 0;
        for(Character c : S.toCharArray()){
            if(map.get(c) != null){
                total = total + 1;
            }
        }
        return total;
    }
}
