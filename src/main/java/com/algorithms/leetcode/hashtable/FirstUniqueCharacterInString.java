package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1120/
 */
public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0) return -1;
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap();
        for(Character c : charArray){
            if(map.get(c) == null){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }
        for(int i=0; i<charArray.length; i++){
            if(map.get(charArray[i]) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args){
        String s = "loveleetcode";
        FirstUniqueCharacterInString firstUniqueCharacterInString = new FirstUniqueCharacterInString();
        System.out.println(firstUniqueCharacterInString.firstUniqChar(s));
    }
}
