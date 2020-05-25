package com.algorithms.ik.stacks;

import java.util.Stack;

public class LongestSubstringWithBalancedParentheses {
    static int find_max_length_of_matching_parentheses(String brackets) {
        if(brackets.length() < 2) return 0;
        boolean[] isMatched = new boolean[brackets.length()];
        char[] charArray = brackets.toCharArray();
        Stack<Integer> stack = new Stack();
        for(int i=0; i<charArray.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                if(charArray[stack.peek()] == '(' && charArray[i] == ')') {
                    isMatched[stack.peek()] = true;
                    isMatched[i] = true;
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        int maxLength = 0;
        int length = 0;
        for(int i=0; i<isMatched.length; i++){
            if(isMatched[i]){
                length++;
                if(length > maxLength) maxLength = length;
            }else if(length > 0){
                length = 0;
            }
        }
        return maxLength;
    }

    public static void main(String[] args){
        //String s = "((((())(((()";
        String s = "()()()";
        System.out.println(find_max_length_of_matching_parentheses(s));
    }
}
