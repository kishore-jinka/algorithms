package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathsInOneZeroMatrix {
    public static int numberOfPaths(List<List<Integer>> matrix) {
        // Write your code here
        int rowSize = matrix.size();
        int columnSize = matrix.get(0).size();
        int[][] dp = new int[rowSize][columnSize];
        dp[0][0] = matrix.get(0).get(0);
        Double d = Math.pow(10,9)+7;
        for(int row=0; row<rowSize; row++){
            for(int column=0; column<columnSize; column++){
                if(matrix.get(row).get(column)>0) {
                    if (row == 0 && column > 0) {
                        if (dp[row][column - 1] > 0) {
                            dp[row][column] = 1;
                        }
                    } else if (row > 0 && column == 0) {
                        if (dp[row - 1][column] > 0) {
                            dp[row][column] = 1;
                        }
                    } else if (row > 0 && column > 0){
                        if (dp[row][column - 1] > 0 && dp[row - 1][column] == 0) {
                            dp[row][column] = dp[row][column - 1];
                        }
                        if (dp[row][column - 1] == 0 && dp[row - 1][column] > 0) {
                            dp[row][column] = dp[row-1][column];
                        }
                        if (dp[row][column - 1] > 0 && dp[row - 1][column] > 0){
                            dp[row][column] = (dp[row][column - 1] + dp[row-1][column])%(d.intValue());
                        }
                    }
                }
            }
        }
        return dp[rowSize-1][columnSize-1];
    }


    public static void main(String[] args){
        List<List<Integer>> matrix1 = new ArrayList<List<Integer>>();
        Integer arr1[] = { 1, 1, 0 };
        List<Integer> list1 = Arrays.asList(arr1);
        Integer arr2[] = { 1, 1, 1 };
        List<Integer> list2 = Arrays.asList(arr2);
        Integer arr3[] = { 0, 1, 1 };
        List<Integer> list3 = Arrays.asList(arr3);
        matrix1.add(list1);
        matrix1.add(list2);
        matrix1.add(list3);
        //System.out.println(numberOfPaths(matrix1));

        List<List<Integer>> matrix2 = new ArrayList<List<Integer>>();
        Integer arr[] = { 1, 1, 1, 1 };
        List<Integer> list = Arrays.asList(arr);
        matrix2.add(list);
        matrix2.add(list);
        matrix2.add(list);
        System.out.println(numberOfPaths(matrix2));

    }

}

/*
Number Of Paths In A Matrix



Problem Statement:



Consider a maze mapped to a matrix with an upper left corner at coordinates (row, column) = (0, 0). You can only move either towards right or down from a cell. You must determine the number of distinct paths through the maze. You will always start at a position (0, 0), the top left, and end up at (n-1, m-1), the bottom right.



As an example, consider the following diagram where '1' indicates an open cell and '0' indicates blocked. You can only travel through open cells, so no path can go through the cell at (0, 2). There are two distinct paths to the goal.





There are two possible paths from the cell (0, 0) to cell (1, 3) in this matrix.



Complete the function numberOfPaths. The function must return the number of paths through the matrix, modulo (10^9 + 7).



Input/Output Format For The Function:



Input Format:



The function contains a single argument, a 2d integer array matrix.



Output Format:



Return an integer, the number of paths to reach from (0, 0) to (n-1, m-1).



Input/Output Format For The Custom Input:



Input Format:



The first line contains integer n, the number of rows. The next line contains integer m, number of columns. Next n lines contain m integers each.

For example:



3

3

1 1 0

1 1 1

0 1 1



Output Format:



Output the number of paths in a single line.



For the above input, the output would be



4



Constraints:



1 <= n*m <= 2*10^6
Each cell, matrix[i][j], contains 1, indicating it is accessible or 0, indicating it is not accessible, where 0<=i<n and 0<=j<m.


Sample Test Cases:



Sample Test Case 1:



Sample Input 1:



3

4

1 1 1 1

1 1 1 1

1 1 1 1



Sample Output 1:



10



Explanation 1:



There are 10 possible paths from cell (0, 0) to cell (2, 3).﻿﻿﻿





Sample Test Case 2:



Sample Input 2:



2

2

1 1

0 1



Sample Output 2:



1



Explanation 2:







There is 1 possible path from the cell (0, 0) to cell (1, 1).
 */
