package com.algorithms.leetcode.dynamicprogramming;

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int totalRows = obstacleGrid.length;
        int totalColumns = obstacleGrid[0].length;
        if(totalRows == 0 && totalColumns == 0) return 0;
        int dp[][] = new int[totalRows][totalColumns];
        if(obstacleGrid[0][0] == 1){
            dp[0][0] = 0;
        }else{
            dp[0][0] = 1;
        }
        for(int column=1; column<totalColumns; column++){
            if(obstacleGrid[0][column] == 1){
                dp[0][column] = 0;
            }else{
                dp[0][column] = dp[0][column-1];
            }
        }
        for(int row=1; row<totalRows; row++){
            if(obstacleGrid[row][0] == 1){
                dp[row][0] = 0;
            }else{
                dp[row][0] = dp[row-1][0];
            }
        }
        for(int row=1; row<totalRows; row++){
            for(int column=1; column<totalColumns; column++){
                if(obstacleGrid[row][column] == 1){
                    dp[row][column] = 0;
                }else {
                    dp[row][column] = dp[row][column - 1] + dp[row - 1][column];
                }
            }
        }
        return dp[totalRows-1][totalColumns-1];
    }
}
