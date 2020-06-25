package com.algorithms.leetcode.dynamicprogramming;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 * //TODO: INCOMPLETE
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int minimum = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    minimum = Math.min(dp[i - coin], minimum);
                }
            }
            dp[i] = minimum + 1;
        }
        if(dp[amount] == Integer.MAX_VALUE + 1) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, 3));
    }
}