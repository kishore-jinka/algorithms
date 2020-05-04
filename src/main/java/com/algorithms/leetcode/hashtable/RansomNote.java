package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() == 0) return false;
        char[] magazineChars = magazine.toCharArray();
        Map<Character, Integer> magazineMap = new HashMap();
        for(char c : magazineChars){
            if(magazineMap.get(c) == null) magazineMap.put(c, 0);
            magazineMap.put(c, magazineMap.get(c) + 1);
        }
        char[] ransomChars = ransomNote.toCharArray();
        Map<Character, Integer> ransomMap = new HashMap();
        for(char c : ransomChars){
            if(ransomMap.get(c) == null) ransomMap.put(c, 0);
            ransomMap.put(c, ransomMap.get(c) + 1);
        }
        for(Character c : ransomMap.keySet()){
            if(magazineMap.get(c) == null) return false;
            if(ransomMap.get(c) > magazineMap.get(c)) return false;
        }
        return true;
    }
}
