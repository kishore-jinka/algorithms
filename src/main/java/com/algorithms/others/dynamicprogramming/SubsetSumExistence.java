package com.algorithms.others.dynamicprogramming;

import java.util.Arrays;

public class SubsetSumExistence {
    static boolean check_if_sum_possible(long[] arr, long k) {
        Arrays.sort(arr);
        return check_if_sum_possible_recursive(arr, k, arr.length-1);
    }

    private static boolean check_if_sum_possible_recursive(long[] array, long total, int endIndex){
        boolean result = false;
        if(endIndex < 0) result = false;
        else if(total == array[endIndex]) result = true;
        else result = check_if_sum_possible_recursive(array, total - array[endIndex], endIndex -1)
                    || check_if_sum_possible_recursive(array, total, endIndex -1);
        return result;
    }

    public static void main(String[] args){
        long[] array = new long[]{2, 4, 6};
        System.out.println(check_if_sum_possible(array, 6));
        System.out.println(check_if_sum_possible(array, 5));
    }
}
