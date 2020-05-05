package com.algorithms.leetcode.queues;

import java.util.Stack;

/**
 * 20. Valid Paranthesis
 * https://leetcode.com/problems/valid-parentheses/
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/
 */
public class ValidParanthesis {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Character> stack = new Stack();
        for(Character c : s.toCharArray()){
            if(stack.isEmpty()) {
                stack.add(c);
            }else {
                Character topMost = stack.peek();
                if ((c == ']' && topMost == '[')
                        || (c == '}' && topMost == '{')
                        || (c == ')' && topMost == '(')) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
