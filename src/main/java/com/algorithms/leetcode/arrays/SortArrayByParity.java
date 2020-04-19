package com.algorithms.leetcode.arrays;


/**
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        if(A.length < 2) return A;
        int orangePointer = -1;
        int greenPointer = 0;
        while(greenPointer < A.length){
            if(A[greenPointer]%2 == 0){
                orangePointer = orangePointer + 1;
                swap(A, greenPointer, orangePointer);
            }
            greenPointer = greenPointer + 1;
        }
        return A;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] a = {3,1,2,4};
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        for(int i:sortArrayByParity.sortArrayByParity(a)) {
            System.out.println(i);
        }
    }
}
