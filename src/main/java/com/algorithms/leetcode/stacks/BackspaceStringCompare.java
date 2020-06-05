package com.algorithms.leetcode.stacks;

import java.util.Stack;

/**
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
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
}
