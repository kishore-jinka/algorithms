package com.algorithms.leetcode.dynamicprogramming;

/**
 * 343. Integer Break
 * https://leetcode.com/problems/integer-break/
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0; //0 cut = 0
        dp[1] = 1; //1 cut = 1
        dp[2] = 1; //2 cut = 1
        for(int i=3; i<=n; i++){
            long[] products = new long[i-1];
            long max=1;
            for(int j=0; j< i-1; j++){
                products[j] = Math.max(((j+1) * dp[i-(j+1)]), (j+1) * (i-(j+1)));
                if (products[j] >= max){
                    max = products[j];
                }
            }
            dp[i] = max;
        }
        return (int) dp[n];
    }
}
