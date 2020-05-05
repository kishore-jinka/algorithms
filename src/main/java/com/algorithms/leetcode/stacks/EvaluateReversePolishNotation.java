package com.algorithms.leetcode.stacks;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack();
        for(String s : tokens){
            //+, -, *, /
            int number = 0;
            if(s.equals("+")){
                int second = stack.pop();
                int first = stack.pop();
                number = first + second;
            }else if(s.equals("-")){
                int second = stack.pop();
                int first = stack.pop();
                number = first - second;
            }else if(s.equals("*")){
                int second = stack.pop();
                int first = stack.pop();
                number = first * second;
            }else if(s.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                number = first / second;
            }else{
                number = Integer.parseInt(s);
            }
            stack.push(number);
        }
        return stack.pop();
    }

    public static void main(String[] args){
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(tokens));
    }
}
