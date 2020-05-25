package com.algorithms.ik.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {

    private static Stack<Integer> stack = new Stack();
    private static Stack<Integer> minimumStack = new Stack();

    private static void push(int x) {
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

    private static void pop() {
        if(!stack.isEmpty()) stack.pop();
        if(!minimumStack.isEmpty()) minimumStack.pop();
    }

    private static int getMin() {
        if(!minimumStack.isEmpty()) return minimumStack.peek();
        return -1;
    }

    static int[] min_stack(int[] operations) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<operations.length; i++){
            if(operations[i] > 0){
                push(operations[i]);
            }else if(operations[i] == 0){
                list.add(getMin());
            }else if(operations[i] == -1){
                pop();
            }
        }
        int[] toReturn = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            toReturn[i] = list.get(i);
        }
        return toReturn;
    }
}
