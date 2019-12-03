package com.algorithms.ik.dynamicprogramming;

public class AmericanFootball {
    private static int getTotalWaysToGetFinalScore(int finalScore){
        int[] dp = new int[finalScore+1];
        dp[0] = 1;
        for(int i = 1; i <= finalScore; i++){
            int s2 = i<2?0:dp[i-2];
            int s3 = i<3?0:dp[i-3];
            int s6 = i<6?0:dp[i-6];
            dp[i] = s2 + s3 + s6;
        }
        return dp[finalScore];
    }

    public static void main(String[] args){
        //allowed points are 2, 3, 6
        int finalScore = 8;
        System.out.println(getTotalWaysToGetFinalScore(finalScore));
    }
}
