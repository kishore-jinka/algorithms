package com.algorithms.ik.dynamicprogramming;

public class MaximumProfit {

    private static int getMaxProfit(int[] a, int[] b){
        int[] dpA = new int[a.length + 1];
        int[] dpB = new int[b.length + 1];
        dpA[0] = 0;
        dpB[0] = 0;
        dpA[1] = a[0];
        dpB[1] = b[0];
        for(int i=2; i<=a.length; i++){
            dpA[i] = a[i-1] + Math.max(dpA[i-1], dpB[i-2]);
            dpB[i] = b[i-1] + Math.max(dpB[i-1], dpA[i-2]);
        }
        return Math.max(dpA[a.length], dpB[a.length]);
    }

    public static void main(String[] args){
        int[] a = {10, 3, 4, 4};
        int[] b = {5, 3, 9, 3};
        System.out.println(getMaxProfit(a,b));
    }
}
