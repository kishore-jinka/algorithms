package com.algorithms.dynamicprogramming;

public class ProfitOnCutPieces {

    /**
     * Cut rod of length n to make maximum profit
     * Rod length 1 = $1
     * Rod length 2 = $10
     * Rod length 3 = $20
     * Rod length 4 = $100
     * Rod length 5 = $75
     * Rod length 6 = $50
     */
    private static int maxProfitOnRod(int[] prizesPerLength, int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            int maxProfit = Integer.MIN_VALUE;
            for(int j=0; j<prizesPerLength.length; j++){
                if(i>j){
                    int profit = prizesPerLength[j] + dp[i-j-1];
                    if(maxProfit < profit) maxProfit = profit;
                }
            }
            dp[i] = maxProfit;
        }
        return dp[n];
    }

    public static void main(String[] args){
        int[] prizesPerLength = {1, 10, 20, 100, 75, 50};
        System.out.println(maxProfitOnRod(prizesPerLength, 25));
    }
}
