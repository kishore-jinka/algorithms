package com.algorithms.leetcode.arrays;

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if(s.length <= 1) return;
        for(int i=0; i<s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
}
