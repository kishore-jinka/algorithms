package com.algorithms.leetcode.hashtable;

import java.util.*;

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return false;
        HashMap<Character, Character> map = new HashMap();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if(sChars.length != tChars.length) return false;

        for(int i=0; i<sChars.length; i++){
            if(map.get(sChars[i]) == null){
                map.put(sChars[i], tChars[i]);
            }else{
                if(map.get(sChars[i]) != tChars[i]) return false;
            }
        }
        map.clear();
        for(int i=0; i<tChars.length; i++){
            if(map.get(tChars[i]) == null){
                map.put(tChars[i], sChars[i]);
            }else{
                if(map.get(tChars[i]) != sChars[i]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("ab","aa"));
    }
}
