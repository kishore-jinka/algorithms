package com.algorithms.leetcode.dynamicprogramming;

/**
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumbers {

    public int fib(int N) {
        int[] dp = new int[N+1];
        dp[0] = 0;
        if(N==0) return dp[0];
        dp[1] = 1;
        if(N==1) return dp[1];
        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    public static void main(String[] args){
        FibonacciNumbers fb = new FibonacciNumbers();
        System.out.println(fb.fib(0));
    }
}
