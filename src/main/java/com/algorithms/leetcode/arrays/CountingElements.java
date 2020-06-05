package com.algorithms.leetcode.arrays;

import java.util.Arrays;

/**
 * 1426. Counting Elements
 * https://leetcode.com/problems/counting-elements/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
 */
public class CountingElements {

    public int countElements(int[] arr) {
        if(arr.length == 0 || arr.length == 1) return 0;
        Arrays.sort(arr);
        int count = 0;
        for(int i: arr){
            int searchIndex = Arrays.binarySearch(arr, i+1);
            if(searchIndex >= 0 && searchIndex < arr.length){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] arr = {1,3,2};
        CountingElements countingElements = new CountingElements();
        System.out.println(countingElements.countElements(arr));
    }
}