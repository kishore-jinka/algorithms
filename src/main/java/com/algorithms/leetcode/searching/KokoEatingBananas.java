package com.algorithms.leetcode.searching;

/**
 * Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 * Surprise: TC is O(NlogN) and not O(logN)
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int start = 1;
        int end = piles[0];
        for(int i=1; i<piles.length; i++) end = Math.max(end, piles[i]);
        while(start <= end){
            int mid = start + (end - start)/2;
            double hours = 0d;
            for(int i=0; i<piles.length; i++){
                hours = hours + Math.ceil((double)piles[i]/(double) mid);
            }
            if(hours > H){ //left zone
                start = mid + 1;
            }else{ //hours <= H right zone
                end = mid - 1;
            }
        }
        return start;
    }
}
