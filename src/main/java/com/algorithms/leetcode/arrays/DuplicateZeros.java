package com.algorithms.leetcode.arrays;

/**
 * 1089. Duplicate Zeros
 * https://leetcode.com/problems/duplicate-zeros/
 * https://leetcode.com/explore/featured/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                for(int j=arr.length-1; j>i; j--){
                    arr[j] = arr[j-1];
                }
                i++;
            }
        }
    }

}