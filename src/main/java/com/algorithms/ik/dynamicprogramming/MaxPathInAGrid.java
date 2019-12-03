package com.algorithms.ik.dynamicprogramming;

public class MaxPathInAGrid {

    private static int getMaxPathValue(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = matrix[0][0];

        for(int rowIndex=0; rowIndex<rows; rowIndex++){
            for(int columnIndex=0; columnIndex<columns; columnIndex++){
                if(rowIndex == 0 && columnIndex > 0){
                    dp[rowIndex][columnIndex] = dp[rowIndex][columnIndex-1] + matrix[rowIndex][columnIndex];
                }else if(rowIndex > 0 && columnIndex == 0){
                    dp[rowIndex][columnIndex] = dp[rowIndex-1][columnIndex] + matrix[rowIndex][columnIndex];
                }else if(rowIndex > 0 && columnIndex > 0){
                    dp[rowIndex][columnIndex] = Math.max(dp[rowIndex-1][columnIndex], dp[rowIndex][columnIndex-1])
                            + matrix[rowIndex][columnIndex];
                }
            }
        }

        return dp[rows-1][columns-1];
    }

    public static void main(String[] args){
        int[][] matrix = new int[7][6];
        matrix[0][2] = 3;
        matrix[1][5] = 7;
        matrix[3][1] = 9;
        matrix[4][0] = 6;
        matrix[4][3] = 5;
        matrix[6][3] = 10;
        System.out.println(getMaxPathValue(matrix));
    }

}

/*

    0   0   3   0   0   0
    0   0   0   0   0   7
    0   0   0   0   0   0
    0   9   0   0   0   0
    6   0   0   5   0   0
    0   0   0   0   0   0
    0   0   0   10  0   0

 */