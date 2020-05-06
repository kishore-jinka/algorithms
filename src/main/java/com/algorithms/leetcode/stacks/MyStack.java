package com.algorithms.leetcode.stacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1387/
 */
public class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
    }

    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue1.isEmpty()){
            throw new RuntimeException("empty stack");
        }else if(queue1.size() == 1){
            return queue1.poll();
        }
        while(queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        int toPop = queue1.poll();
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        return toPop;
    }

    /** Get the top element. */
    public int top() {
        if(queue1.isEmpty()){
            throw new RuntimeException("empty stack");
        }else if(queue1.size() == 1){
            return queue1.peek();
        }
        while(queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        int top = queue1.poll();
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        queue1.add(top);
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
