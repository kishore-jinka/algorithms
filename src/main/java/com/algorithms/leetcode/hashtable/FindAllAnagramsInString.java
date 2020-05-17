package com.algorithms.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
 * TODO: 34/36 test cases passed. Time Limit Exceeded
 */
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(p == null || s == null || p.length() == 0 || s.length() == 0
                || p.length() > s.length()) {
            return list;
        }
        Map<Character, Integer> pMap = new HashMap<Character, Integer>();
        for(char c : p.toCharArray()){
            if(pMap.get(c) == null){
                pMap.put(c, 0);
            }
            pMap.put(c, pMap.get(c) + 1);
        }
        char[] sChars = s.toCharArray();
        for(int i=0; i<sChars.length; i++){
            Map<Character, Integer> pMapCopy = new HashMap<Character, Integer>(pMap);
            int match = pMapCopy.size();
            int jLength = sChars.length < i+p.length() ? sChars.length : i+p.length();
            for(int j=i; j<jLength; j++){
                if(pMapCopy.get(sChars[j]) == null || pMapCopy.get(sChars[j]) == 0){
                    break;
                }else{
                    int charRep = pMapCopy.get(sChars[j]) - 1;
                    if(charRep == 0) match--;
                    pMapCopy.put(sChars[j], charRep);
                }
            }
            if(match == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";
        FindAllAnagramsInString findAllAnagramsInString = new FindAllAnagramsInString();
        List<Integer> list = findAllAnagramsInString.findAnagrams(s, p);
        System.out.println(list);
    }
}
