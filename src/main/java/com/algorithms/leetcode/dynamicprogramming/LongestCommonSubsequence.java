package com.algorithms.leetcode.dynamicprogramming;

/**
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1.trim().length() == 0 || text2 == null || text2.trim().length() == 0) return 0;
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        dp[0][0] = 0;
        for(int column = 1; column <= text2.length(); column++){
            dp[0][column] = 0;
        }
        for(int row = 1; row <= text1.length(); row++){
            dp[row][0] = 0;
        }
        for(int row=1; row<=text1.length(); row++){
            for(int column=1; column<=text2.length(); column++){
                if (text1.charAt(row-1) == text2.charAt(column-1)) {
                    dp[row][column] =  dp[row-1][column-1] + 1;
                }else{
                    dp[row][column] = Math.max(dp[row-1][column], dp[row][column-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args){
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence(text1, text2));
    }
}
