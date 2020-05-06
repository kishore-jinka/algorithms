package com.algorithms.leetcode.queues;

import java.util.Stack;

/**
 * 232. Implement Stack using Queues
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1386/
 */
public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack1.isEmpty()){
            throw new RuntimeException("empty queue");
        }else if(stack1.size() == 1){
            return stack1.pop();
        }
        while(stack1.size() != 1){
            stack2.push(stack1.pop());
        }
        int toPop = stack1.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return toPop;
    }

    /** Get the front element. */
    public int peek() {
        if(stack1.isEmpty()){
            throw new RuntimeException("empty queue");
        }else if(stack1.size() == 1){
            return stack1.peek();
        }
        while(stack1.size() != 1){
            stack2.push(stack1.pop());
        }
        int toPop = stack1.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return toPop;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
