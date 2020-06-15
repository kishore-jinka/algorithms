package com.algorithms.leetcode.dynamicprogramming;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[n][m];
        dp[0][0] = 1;
        for(int row=0; row<n; row++){
            for(int column=0; column<m; column++){
                if(row == 0 && column > 0){
                    dp[row][column] = dp[row][column-1];
                }else if(row > 0 && column == 0){
                    dp[row][column] = dp[row-1][column];
                }else if(row > 0 && column > 0){
                    dp[row][column] = dp[row][column-1] + dp[row-1][column];
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args){
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 2));
    }
}
