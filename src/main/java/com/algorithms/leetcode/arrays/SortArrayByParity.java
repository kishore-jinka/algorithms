package com.algorithms.leetcode.arrays;


/**
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        if(A == null) return null;
        if(A.length == 1) return A;
        int frontEndIterator = 0;
        int backEndIterator = A.length-1;
        while(frontEndIterator<backEndIterator){
            if(A[frontEndIterator]%2 == 1 && A[backEndIterator]%2 == 0){
                int tmp = A[frontEndIterator];
                A[frontEndIterator] = A[backEndIterator];
                A[backEndIterator] = tmp;
                frontEndIterator++;
                backEndIterator--;
            }else if(A[frontEndIterator]%2 == 1 && A[backEndIterator]%2 == 1){
                backEndIterator--;
            }else if(A[frontEndIterator]%2 == 0 && A[backEndIterator]%2 == 0){
                frontEndIterator++;
            }else if(A[frontEndIterator]%2 == 0 && A[backEndIterator]%2 == 1){
                frontEndIterator++;
                backEndIterator--;
            }
        }
        return A;
    }

    public static void main(String[] args){
        int[] a = {3,1,2,4};
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        for(int i:sortArrayByParity.sortArrayByParity(a)) {
            System.out.println(i);
        }
    }
}
