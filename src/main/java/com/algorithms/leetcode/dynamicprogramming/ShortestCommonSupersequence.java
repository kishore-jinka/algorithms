package com.algorithms.leetcode.dynamicprogramming;

/**
 * 1092. Shortest Common Supersequence
 * https://leetcode.com/problems/shortest-common-supersequence/
 */
public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        //if(str1 == null || str1.trim().length() == 0 || str2 == null || str2.trim().length() == 0) return 0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        dp[0][0] = 0;
        for(int column = 1; column <= str2.length(); column++){
            dp[0][column] = 0;
        }
        for(int row = 1; row <= str1.length(); row++){
            dp[row][0] = 0;
        }
        for(int row=1; row<=str1.length(); row++){
            for(int column=1; column<=str2.length(); column++){
                if (str1.charAt(row-1) == str2.charAt(column-1)) {
                    dp[row][column] =  dp[row-1][column-1] + 1;
                }else{
                    dp[row][column] = Math.max(dp[row-1][column], dp[row][column-1]);
                }
            }
        }

        int row = str1.length();
        int column = str2.length();
        String result = "";
        while(row != 0 && column !=0){
            if(dp[row][column] == dp[row-1][column]){
                result = str1.charAt(row-1) + result;
                row = row - 1;
            }else if(dp[row][column] == dp[row][column-1]){
                result = str2.charAt(column-1)  + result;
                column = column - 1;
            }else{
                result = str1.charAt(row-1) + result;
                row = row - 1;
                column = column - 1;
            }
        }
        while(row != 0){
            result = str1.charAt(row-1) + result;
            row = row - 1;
        }
        while(column != 0) {
            result = str2.charAt(column - 1) + result;
            column = column - 1;
        }
        return result;
    }

    public static void main(String[] args){
        String str1 = "abac";
        String str2 = "cab";
        ShortestCommonSupersequence shortestCommonSupersequence = new ShortestCommonSupersequence();
        System.out.println(shortestCommonSupersequence.shortestCommonSupersequence(str1, str2));
    }
}
