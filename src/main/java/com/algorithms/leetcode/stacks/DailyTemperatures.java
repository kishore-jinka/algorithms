package com.algorithms.leetcode.stacks;

import java.util.Stack;

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if(T.length == 0) return T;
        if(T.length == 1) return new int[1];
        int[] days = new int[T.length];
        days[days.length - 1] = 0;
        Stack<Integer> stack = new Stack();
        stack.push(days.length - 1);
        for(int i=T.length-2; i>=0; i--){
            if(T[i] < T[i+1]){
                days[i] = 1;
            }else{
                while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                    stack.pop();
                }
                if(!stack.isEmpty()) days[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return days;
    }

    public static void main(String[] args){
        //int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temps = {89,62,70,58,47,47,46,76,100,70};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] days = dailyTemperatures.dailyTemperatures(temps);
        for(int day : days) {
            System.out.println(day);
        }

    }
}
