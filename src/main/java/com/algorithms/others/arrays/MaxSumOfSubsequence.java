package com.algorithms.others.arrays;

public class MaxSumOfSubsequence {

    public int maxSum(int[] array, int k){
        //assuming array is mutable
        for(int i=k; i<array.length; i++)
            array[i%k] = array[i%k] + array[i];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<k; i++)
            if(max < array[i]) max = array[i];
        return max;
    }

    public static void main(String[] args){
        int array[] = {2, 3, -1, -1, 2};
        int k = 2;
        MaxSumOfSubsequence maxSumOfSubsequence = new MaxSumOfSubsequence();
        int max = maxSumOfSubsequence.maxSum(array, k);
        System.out.println(max);
    }
}
