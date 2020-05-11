package com.algorithms.leetcode.recursion;

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 * https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
 */
public class Powerxn {

    public double myPow(double x, int n) {
        if(x == 0 && n > 0) return 0;
        if(x == 0 && n <= 0) return Double.NaN;
        long longN = n;
        if (longN < 0) {
            x = 1 / x;
            longN = -longN;
        }

        return recursivePow(x, longN);
    }

    private double recursivePow(double x, long n) {
        if (n == 0) {
            return 1.0d;
        }
        double half = recursivePow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }


    public static void main(String[] args){
        Powerxn pxn = new Powerxn();
        System.out.println(pxn.myPow(2d, 10));
    }
}