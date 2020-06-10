package com.algorithms.leetcode.searching;

/**
 * 1228. Missing Number In Arithmetic Progression
 * https://leetcode.com/problems/missing-number-in-arithmetic-progression/
 */
public class MissingNumberInArithmeticProgression {
    public int missingNumber(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int commonDifference = (arr[end] - arr[start])/arr.length;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == arr[0] + mid * commonDifference){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return arr[end] + commonDifference;
    }
}
