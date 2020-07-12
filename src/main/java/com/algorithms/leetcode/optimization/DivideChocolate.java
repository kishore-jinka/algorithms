package com.algorithms.leetcode.optimization;

/**
 * 1231. Divide Chocolate
 * https://leetcode.com/problems/divide-chocolate/
 */
public class DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int K) {
        int start = sweetness[0];
        int end = sweetness[0];
        for(int i=1; i<sweetness.length; i++){
            start = Math.min(start, sweetness[i]);
            end = end + sweetness[i];
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            int totalSweetness = 0;
            int pieces = 0;
            for(int i=0; i<sweetness.length; i++){
                totalSweetness = totalSweetness + sweetness[i];
                if(totalSweetness >= mid){
                    totalSweetness = 0;
                    pieces = pieces+1;
                }
            }
            if(pieces < K+1){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }
}
