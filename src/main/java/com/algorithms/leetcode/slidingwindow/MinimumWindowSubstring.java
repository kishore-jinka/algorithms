package com.algorithms.leetcode.slidingwindow;

import java.util.*;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 * Really really complex solution (I can't think of a more complex problem than this)
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int frontPointer = 0;
        int rearPointer = 0;
        int minStringStart = 0;
        int minStringEnd = 0;
        int minDifference = s.length();
        String minString = "";
        List<Integer> zeroList = new ArrayList();
        zeroList.add(0);
        Map<Character,Integer> tMap = new HashMap();
        for(Character c : t.toCharArray()){
            if(tMap.get(c) == null) tMap.put(c,0);
            tMap.put(c, tMap.get(c) + 1);
        }
        Set<Character> keySet = tMap.keySet();
        Map<Character, Integer> sMap = new HashMap();
        for(Character c : t.toCharArray()){
            sMap.put(c,0);
        }
        while(rearPointer<s.length() && frontPointer < s.length()){
            if(!areMapsEqual(sMap,tMap)){
                Character frontChar = s.charAt(frontPointer);
                if(keySet.contains(frontChar)){
                    sMap.put(frontChar, sMap.get(frontChar) + 1);
                    if(areMapsEqual(sMap,tMap)){
                        minStringEnd = frontPointer;
                        if(minStringEnd - minStringStart < minDifference){
                            minDifference = minStringEnd - minStringStart;
                            minString = s.substring(minStringStart, minStringEnd+1);
                        }
                    }else {
                        frontPointer++;
                    }
                }else{
                    frontPointer++;
                }
            }else{
                if(rearPointer > 0) {
                    Character previousRearChar = s.charAt(rearPointer - 1);
                    if (keySet.contains(previousRearChar)) {
                        sMap.put(previousRearChar, sMap.get(previousRearChar) - 1);
                        if (!areMapsEqual(sMap,tMap)) {
                            minStringStart = rearPointer - 1;
                            if(minStringEnd - minStringStart < minDifference){
                                minDifference = minStringEnd - minStringStart;
                                minString = s.substring(minStringStart, minStringEnd+1);
                            }
                            frontPointer++;
                        }

                    }else{
                        minStringStart = rearPointer;
                        if(minStringEnd - minStringStart < minDifference){
                            minDifference = minStringEnd - minStringStart;
                            minString = s.substring(minStringStart, minStringEnd+1);
                        }
                    }
                }
                rearPointer++;

            }
        }
        return minString;
    }

    private boolean areMapsEqual(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        for(Iterator<Character> i=sMap.keySet().iterator(); i.hasNext();){
            Character c = i.next();
            if(sMap.get(c) < tMap.get(c)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        //String s = "ADOBECODEBANC";
        //String t = "AABC";
        String s = "a";
        String t = "aa";
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow(s,t));
    }
}

/*

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

 */
