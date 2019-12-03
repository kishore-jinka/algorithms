package com.algorithms.leetcode.recursion;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrixEmpty(matrix)) return false;
        return  searchRowsColumns(0, 0, matrix, target);
    }

    private boolean searchRowsColumns(int row, int column, int[][] matrix, int target){
        if(row >= matrix.length) return false;
        if(column >= matrix[0].length) return false;
        //search the row through all columns
        for(int i= column; i<matrix[0].length; i++){
            if(matrix[row][i] == target) return true;
        }
        //search the column throw all rows
        for(int j= row; j<matrix.length; j++){
            if(matrix[j][column] == target) return true;
        }
        return searchRowsColumns(row+1, column+1, matrix, target);
    }

    private boolean matrixEmpty(int[][] matrix){
        if(matrix == null) return true;
        for(int[] row : matrix){
            if(row.length == 0) return true;
        }
        return false;
    }

    public static void main(String[] args){
        Search2DMatrix s = new Search2DMatrix();
        int[][] matrix ={{1, 4, 7, 11, 15},
                         {2, 5, 8, 12, 19},
                         {3, 6, 9, 16, 22},
                         {10, 13, 14, 17, 24},
                         {18, 21, 23, 26, 30}};
        System.out.println(s.searchMatrix(matrix, 10));
        System.out.println(s.searchMatrix(matrix, 30));
        System.out.println(s.searchMatrix(matrix, 24));
        System.out.println(s.searchMatrix(matrix, 25));
        int[][] matrix2 = {{}};
        System.out.println(s.searchMatrix(matrix2, 2));
        int[][] matrix3 = null;
        System.out.println(s.searchMatrix(matrix3, 3));
        int[][] matrix4 = {{-1},{-1}};
        System.out.println(s.searchMatrix(matrix4, -2));
    }
}

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */