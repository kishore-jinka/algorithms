package com.algorithms.leetcode.dynamicprogramming;

/**
 * 518. Coin Change 2
 * https://leetcode.com/problems/coin-change-2/
 * TODO: INCOMPLETE: Don't really know why leetcode doesn't accept this
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        if(coins.length == 0 || amount < 1) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=1; i<=amount; i++){
            int count = 0;
            for(int coin : coins){
                if(i == coin) count += 1;
                if(i > coin && dp[i-coin] > 0) count += dp[i-coin];
            }
            dp[i] = count;
        }
        return dp[amount];
    }
}
