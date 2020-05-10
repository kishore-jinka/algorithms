package com.algorithms.leetcode.adhoc;

/**
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        double doubleNum = num;
        double doubleSqrtRoot = Math.sqrt(doubleNum);
        int intSqrtRoot = (int) doubleSqrtRoot;
        if(intSqrtRoot * intSqrtRoot == num) return true;
        return false;
    }
}
