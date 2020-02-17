package com.algorithms.leetcode.slidingwindow;

import java.util.*;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 * TODO: INCOMPLETE
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int frontPointer = 0;
        int rearPointer = 0;
        int minStringStart = 0;
        int minStringEnd = 0;
        List<Integer> zeroList = new ArrayList();
        zeroList.add(0);
        Map<Character,Integer> characterMap = new HashMap();
        for(Character c : t.toCharArray()){
            characterMap.put(c,0);
        }
        Set<Character> keySet = characterMap.keySet();
        int missingCharacters = keySet.size();
        while(rearPointer<s.length() && frontPointer <= s.length()+1){
            if(missingCharacters > 0){
                Character frontChar = s.charAt(frontPointer);
                if(keySet.contains(frontChar)){
                    Integer value = characterMap.get(frontChar);
                    //Insert into characterMap
                    characterMap.put(frontChar, ++value);
                    //Decrement missingCharactersSet.
                    Collection<Integer> values = new HashSet(characterMap.values());
                    values.retainAll(zeroList);
                    missingCharacters = values.size();
                    if(missingCharacters == 0){
                        //if missingCharacters == 0 then update minStringEnd based on length comparision.
                        minStringEnd = frontPointer;
                        System.out.println(s.substring(minStringStart, minStringEnd+1));
                    }else {
                        //If atleast one value in character map values is 0 then increment front pointer
                        //missingCharacters > 0
                        frontPointer++;
                    }
                }else{
                    //missingCharacters > 0
                    frontPointer++;
                }
            }else{
                //Character rearChar = s.charAt(rearPointer);
                if(rearPointer > 0){
                    Character previousRearChar = s.charAt(rearPointer - 1);
                    if(keySet.contains(previousRearChar)) {
                        Integer value = characterMap.get(previousRearChar);
                        //Remove from characterMap
                        characterMap.put(previousRearChar, --value);
                        //Decrement missingCharactersSet.
                        Collection<Integer> values = new HashSet(characterMap.values());
                        values.retainAll(zeroList);
                        missingCharacters = values.size();
                        if (missingCharacters > 0) {
                            //if missingCharacters > 0 then update minStringStart based on length comparision.
                            minStringStart = rearPointer - 1;
                            System.out.println(s.substring(minStringStart, minStringEnd + 1));
                        } else {
                            //If missingCharacters == 0 increment rear pointer
                            rearPointer++;
                        }
                    }
                }else{
                    //If missingCharacters == 0 increment rear pointer
                    rearPointer++;
                }
            }

            //if all values > 0 then increment rearPointer
            //

        }
        return "";
    }

    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow(s,t));
    }
}

/*

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

 */
