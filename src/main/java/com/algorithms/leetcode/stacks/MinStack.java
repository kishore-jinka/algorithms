package com.algorithms.leetcode.stacks;

import java.util.Stack;

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3292/
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minimumStack;

    public MinStack() {
        stack = new Stack();
        minimumStack = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if(minimumStack.isEmpty()){
            minimumStack.push(x);
        }else{
            int minStackTop = minimumStack.peek();
            if(x <= minStackTop){
                minimumStack.push(x);
            }else{
                minimumStack.push(minStackTop);
            }
        }
    }

    public void pop() {
        if(!stack.isEmpty()) stack.pop();
        if(!minimumStack.isEmpty()) minimumStack.pop();
    }

    public int top() {
        if(!stack.isEmpty()) return stack.peek();
        return Integer.MIN_VALUE;
    }

    public int getMin() {
        if(!minimumStack.isEmpty()) return minimumStack.peek();
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      // Returns 0.
        System.out.println(minStack.getMin());   // Returns -2.
    }
}
