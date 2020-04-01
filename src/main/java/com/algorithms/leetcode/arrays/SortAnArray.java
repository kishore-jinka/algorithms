package com.algorithms.leetcode.arrays;

/**
 * 912. Sort An Array
 * https://leetcode.com/problems/sort-an-array/
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length -1);
    }

    private int[] sort(int[] toSort, int startIndex, int endIndex){
        if(startIndex < endIndex) {
            int middle = (startIndex + endIndex) / 2;
            int[] leftSortedArray = sort(toSort, startIndex, middle);
            int[] rightSortedArray = sort(toSort, middle + 1, endIndex);
            return merge(leftSortedArray, rightSortedArray);
        }
        return new int[]{toSort[startIndex]};
    }

    private int[] merge(int[] a, int[] b){
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, m = 0;
        while(i<a.length && j<b.length){
            if(a[i] <= b[j]){
                merged[m++] = a[i++];
            } else {
                merged[m++] = b[j++];
            }
        }
        if(i<a.length){
            while(i<a.length) merged[m++] = a[i++];
        }
        if(j<b.length){
            while(j<b.length) merged[m++] = b[j++];
        }
        return merged;
    }
}
