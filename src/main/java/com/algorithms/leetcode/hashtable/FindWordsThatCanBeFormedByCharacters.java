package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. Find Words That Can Be Formed by Characters
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charsMap = new HashMap();
        char[] charArray = chars.toCharArray();
        for(int i=0; i<charArray.length; i++){
            if(charsMap.get(charArray[i]) == null) charsMap.put(charArray[i], 0);
            charsMap.put(charArray[i], charsMap.get(charArray[i]) + 1);
        }
        int count = 0;
        for(int i=0; i<words.length; i++){
            Map<Character, Integer> newCharsMap = new HashMap(charsMap);
            char[] characters = words[i].toCharArray();
            boolean found = true;
            for(int j=0; j<characters.length; j++){
                if(newCharsMap.get(characters[j]) == null || newCharsMap.get(characters[j]) == 0){
                    found = false;
                    break;
                }else{
                    newCharsMap.put(characters[j], newCharsMap.get(characters[j]) - 1);
                }
            }
            if(found) count = count + words[i].length();
        }
        return count;
    }

    public static void main(String[] args){
        //String[] words = {"cat","bt","hat","tree"};
        //String chars = "atach";
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        FindWordsThatCanBeFormedByCharacters findWords = new FindWordsThatCanBeFormedByCharacters();
        System.out.println(findWords.countCharacters(words, chars));
    }
}

/*
Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 */