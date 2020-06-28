package com.algorithms.leetcode.searching;

/**
 * 441. Arranging Coins
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long longN = n;
        long start = 0;
        long end = longN;
        while(start <= end){
            long mid = start + (end - start)/2;
            long stepSum = mid*(mid+1)/2;
            if(stepSum == longN){
                return (int) mid;
            }else if(stepSum < longN){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return (int) end;
    }
}
