package com.algorithms.leetcode.strings;

import java.util.Stack;

/**
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        if(S == null || T == null) return false;
        Stack<Character> stackS = new Stack();
        for(Character c : S.toCharArray()){
            if(!stackS.isEmpty() && c == '#'){
                stackS.pop();
            }
            if(c != '#') stackS.push(c);
        }
        Stack<Character> stackT = new Stack();
        for(Character c : T.toCharArray()){
            if(!stackT.isEmpty() && c == '#'){
                stackT.pop();
            }
            if(c != '#') stackT.push(c);
        }

        while(!stackS.isEmpty() && !stackT.isEmpty()){
            if(stackS.pop() != stackT.pop()) return false;
        }

        return stackS.isEmpty() && stackT.isEmpty();
    }

    public static void main(String[] args){
        String S = "a##c", T = "#a#c";
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare(S,T));
    }

}

/*
 Example 1:

 Input: S = "ab#c", T = "ad#c"
 Output: true
 Explanation: Both S and T become "ac".
 Example 2:

 Input: S = "ab##", T = "c#d#"
 Output: true
 Explanation: Both S and T become "".
 Example 3:

 Input: S = "a##c", T = "#a#c"
 Output: true
 Explanation: Both S and T become "c".
 Example 4:

 Input: S = "a#c", T = "b"
 Output: false
 Explanation: S becomes "c" while T becomes "b".
 */