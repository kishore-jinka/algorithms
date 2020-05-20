package com.algorithms.ik.recursion;

/**
 * TODO: INCOMPLETE
 */
public class CalculatePower {
    public static int calculate_power(long a, long b) {
        if(a == 0 && b > 0) return 0;
        return (int)(recursivePow(a, b) % 1000000007L);
    }

    private static long recursivePow(long a, long b) {
        if (b == 0) {
            return 1L;
        }
        long half = recursivePow(a, b / 2);
        if (b % 2 == 0) {
            return half * half;
        } else {
            return half * half * a;
        }
    }

    public static void main(String[] args){
        System.out.println(calculate_power(2, 10));
    }
}