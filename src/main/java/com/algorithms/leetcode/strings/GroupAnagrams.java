package com.algorithms.leetcode.strings;

import java.util.*;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3288/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedChars = new String(chars);
            if(anagramMap.get(sortedChars) == null){
                anagramMap.put(sortedChars, new ArrayList<String>());
            }
            anagramMap.get(sortedChars).add(s);
        }
        List<List<String>> anagramGroup = new ArrayList();
        anagramGroup.addAll(anagramMap.values());
        return anagramGroup;
    }
}
