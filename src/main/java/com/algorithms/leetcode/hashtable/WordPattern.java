package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> patternMap = new HashMap<Character, String>();
        Map<String, Character> strMap = new HashMap<String, Character>();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        char[] characters = pattern.toCharArray();
        if(characters.length != tokenizer.countTokens()) return false;
        for(int i=0; i<pattern.length(); i++){
            if(!tokenizer.hasMoreTokens()) return false;
            String substring = tokenizer.nextToken();
            char patternChar = characters[i];
            if(patternMap.get(patternChar) == null){
                patternMap.put(patternChar, substring);
            }else{
                if(!patternMap.get(patternChar).equals(substring)) return false;
            }
            if(strMap.get(substring) == null){
                strMap.put(substring, patternChar);
            }else{
                if(!strMap.get(substring).equals(patternChar)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String pattern = "abba";
        String str = "dog cat cat dog";
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern(pattern,str));
    }
}

/*
Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
 */