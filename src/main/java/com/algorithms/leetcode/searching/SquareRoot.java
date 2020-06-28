package com.algorithms.leetcode.searching;

/**
 * 69. Square Root
 * https://leetcode.com/problems/sqrtx/
 */
public class SquareRoot {
    public int mySqrt(int x) {
        long longX = x;
        long start = 0;
        long end = longX;
        while(start <= end){
            long mid = start + (end - start)/2;
            long square = mid*mid;
            if(square == longX){
                return (int) mid;
            }else if(square < longX){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return (int) start - 1;
    }

    public static void main(String[] args){
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.mySqrt(2147395599));
    }
}
