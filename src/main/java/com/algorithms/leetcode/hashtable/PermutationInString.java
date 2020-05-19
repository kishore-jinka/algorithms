package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
 * TODO: 77 / 103 test cases passed. Time Limit Exceeded
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0
                || s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<Character, Integer>();
        for(char c : s1.toCharArray()){
            if(s1Map.get(c) == null){
                s1Map.put(c, 0);
            }
            s1Map.put(c, s1Map.get(c) + 1);
        }
        char[] sChars = s2.toCharArray();
        for(int i=0; i<sChars.length; i++){
            Map<Character, Integer> s1MapCopy = new HashMap<Character, Integer>(s1Map);
            int match = s1MapCopy.size();
            int jLength = sChars.length < i+s1.length() ? sChars.length : i+s1.length();
            for(int j=i; j<jLength; j++){
                if(s1MapCopy.get(sChars[j]) == null || s1MapCopy.get(sChars[j]) == 0){
                    break;
                }else{
                    int charRep = s1MapCopy.get(sChars[j]) - 1;
                    if(charRep == 0) match--;
                    s1MapCopy.put(sChars[j], charRep);
                }
            }
            if(match == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String s1 = "abcf";
        String s2 = "cbaebabacd";
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion(s1, s2));
    }
}
