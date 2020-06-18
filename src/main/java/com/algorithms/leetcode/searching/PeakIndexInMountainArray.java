package com.algorithms.leetcode.searching;

/**
 * 852. Peak Index in a Mountain Array
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(A[mid] > A[mid-1] && A[mid] > A[mid+1]){
                return mid;
            }else if(A[mid] > A[mid-1]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
