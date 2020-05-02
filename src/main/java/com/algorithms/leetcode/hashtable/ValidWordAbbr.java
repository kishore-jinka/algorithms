package com.algorithms.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 288. Unique Word Abbreviation
 * https://leetcode.com/problems/unique-word-abbreviation/
 * https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1137/
 * Really weird problem as the definition of problem on leetcode assume manythings and don't tell us.
 * Whoever designed this problem really didn't think much. I wonder how leetcode accepted such definitions.
 */
public class ValidWordAbbr {

    String[] dictionary;
    Map<String, List<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        this.dictionary = dictionary;
        map = new HashMap();
        for(String s : this.dictionary){
            String key = s;
            if(s.length() > 2 ){
                key = s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1);
            }
            if(map.get(key) == null){
                List<String> list = new ArrayList();
                list.add(s);
                map.put(key, list);
            }else{
                map.get(key).add(s);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = word;
        if(word.length() > 2){
            key = word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1);
        }
        List<String> list = map.get(key);
        if(list == null){
            return true;
        }else{
            if(word.length() >= 3 && list.size() == 1 && list.get(0).equals(word)){
                return true;
            }else if(word.length() < 3 && list.size() >=1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String[] dictionary = {"deer", "door", "cake", "card"};
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(dictionary);
        System.out.println(validWordAbbr.isUnique("dear"));
        System.out.println(validWordAbbr.isUnique("cart"));
        System.out.println(validWordAbbr.isUnique("cane"));
        System.out.println(validWordAbbr.isUnique("make"));
//        String[] dictionary = {"a", "a"};
//        ValidWordAbbr validWordAbbr = new ValidWordAbbr(dictionary);
//        System.out.println(validWordAbbr.isUnique("a"));
    }
}
