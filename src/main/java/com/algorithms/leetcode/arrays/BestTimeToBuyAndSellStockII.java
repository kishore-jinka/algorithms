package com.algorithms.leetcode.arrays;

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3287/
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        int min=prices[0];
        int maxProfit=0;
        for(int i=1; i<prices.length; i++){
            if(i==1){
                if (prices[i] < prices[i - 1]) {
                    min = prices[i];
                }
            }else {
                if (prices[i] < prices[i - 1]) {
                    maxProfit = maxProfit + (prices[i-1] - min);
                    min = prices[i];
                }
            }
            if(i == prices.length-1){
                if(prices[i] >= prices[i-1]){
                    maxProfit = maxProfit + (prices[i] - min);
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = {1,9,6,9,1,7,1,1,5,9,9,9}; //[1,9,6,9,1,7,1,1,5,9,9,9]
        BestTimeToBuyAndSellStockII sellStockII = new BestTimeToBuyAndSellStockII();
        System.out.println(sellStockII.maxProfit(prices));
    }


}
