package com.algorithms.leetcode.dynamicprogramming;

/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int[][] minSum = new int[grid.length][grid[0].length];
        for(int row=0; row<grid.length; row++){
            for(int column=0; column<grid[0].length; column++){
                if(row==0 && column==0){
                    minSum[row][column] = grid[0][0];
                }else if(row == 0 && column > 0){
                    minSum[row][column] = grid[row][column] + minSum[row][column-1];
                }else if(row > 0 && column == 0){
                    minSum[row][column] = grid[row][column] + minSum[row-1][column];
                }else if(row > 0 && column > 0){
                    minSum[row][column] = grid[row][column] + Math.min(minSum[row][column-1], minSum[row-1][column]);
                }
            }
        }
        return minSum[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args){
        int[][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));

    }
}
