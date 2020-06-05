package com.algorithms.leetcode.arrays;

/**
 * 941. Valid Mountain Array
 * https://leetcode.com/problems/valid-mountain-array/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        boolean increasing = true;
        for(int i=1; i<A.length; i++){
            if(A[i] == A[i-1]) return false;
            if(increasing) {
                if (A[i] < A[i-1]){
                    if(i==1) return false;
                    increasing = false;
                }
            }else{
                if (A[i] > A[i-1]){
                    return false;
                }
            }
        }
        if(increasing) return false;
        return true;
    }

    public static void main(String[] args){
        int[] A = {0,2,3,3,5,2,1,0};
        ValidMountainArray validMountainArray = new ValidMountainArray();
        System.out.println(validMountainArray.validMountainArray(A));
    }
}

