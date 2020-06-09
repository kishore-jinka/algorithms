package com.algorithms.leetcode.searching;

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int start = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int end = rows*columns - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(matrix[mid/columns][mid%columns] == target) return true;
            if(matrix[mid/columns][mid%columns] < target) start = mid + 1;
            if(matrix[mid/columns][mid%columns] > target) end = mid - 1;
        }
        return false;
    }
}
