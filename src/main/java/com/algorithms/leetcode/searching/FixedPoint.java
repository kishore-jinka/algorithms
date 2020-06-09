package com.algorithms.leetcode.searching;

/**
 * 1064. Fixed Point
 * https://leetcode.com/problems/fixed-point/
 */
public class FixedPoint {
    public int fixedPoint(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(A[mid] < mid){
                start = mid + 1;
            } else { //A[mid] >= mid
                end = mid - 1;
            }
        }
        if (start < A.length && A[start] == start) return start;
        return -1;
    }
}
