package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1135/
 */
public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int maxLength = 0;
        int index = 0;
        Map<Character, Integer> map = new HashMap();
        char[] charArray = s.toCharArray();
        for(int i=0; i<charArray.length; i++){
            Character c = charArray[i];
            if(map.get(c) != null && index < map.get(c) + 1){
                index = map.get(c) + 1;
            }
            map.put(c, i);
            int length = i - index + 1;
            if(maxLength < length) maxLength = length;
        }
        return maxLength;
    }

    public static void main(String[] args){
        String s = "abcabcbb";
        LongestSubstringWithoutRepeating longestSubstringWithoutRepeating = new LongestSubstringWithoutRepeating();
        System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring(s));
    }
}
