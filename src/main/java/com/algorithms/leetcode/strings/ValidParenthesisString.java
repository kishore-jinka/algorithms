package com.algorithms.leetcode.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 678. Valid Parenthesis String
 * https://leetcode.com/problems/valid-parenthesis-string/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        Stack<Character> stack1 = new Stack();

        for(Character c : s.toCharArray()){
            if(c.equals('(') || c.equals('*')){
                stack1.push(c);
            }
            if(c.equals(')')){
                if(stack1.isEmpty() || stack1.peek().equals(')')){
                    stack1.push(c);
                }else if(stack1.peek().equals('(')){
                    stack1.pop();
                }else if(stack1.peek().equals('*')){
                    int numberOfStars = 0;
                    while(!stack1.isEmpty() && stack1.peek().equals('*')){
                        stack1.pop();
                        numberOfStars++;
                    }
                    if(!stack1.isEmpty()) {
                        if (stack1.peek().equals('(')) {
                            stack1.pop();
                            for (int i = 0; i < numberOfStars; i++) {
                                stack1.push('*');
                            }
                        } else if (stack1.peek().equals(')')) {
                            for (int i = 0; i < numberOfStars; i++) {
                                stack1.push('*');
                            }
                            stack1.push(c);
                        }
                    }else{
                        for (int i = 0; i < numberOfStars; i++) {
                            stack1.push('*');
                        }
                        stack1.push(c);
                    }
                }
            }
        }
        List<Character> characterList = new ArrayList<Character>();
        while(!stack1.isEmpty()){
            characterList.add(0,stack1.pop());
        }
        for(Character c : characterList){
            if(stack1.isEmpty()){
                stack1.push(c);
            }else if(stack1.peek().equals('(') && c.equals('*')){
                stack1.pop();
            }else if(stack1.peek().equals('*') && c.equals(')')){
                stack1.pop();
            }else{
                stack1.push(c);
            }
        }
        System.out.println(stack1);
        if(stack1.indexOf('(') > -1 || stack1.indexOf(')') > -1) return false;
        return true;
    }


    public static void main(String[] args){
        //String s = "(*((((()***)";
        String s = ")(((*))";
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString(s));
    }
}
