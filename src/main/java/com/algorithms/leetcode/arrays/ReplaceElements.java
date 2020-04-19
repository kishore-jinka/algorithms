package com.algorithms.leetcode.arrays;

/**
 * 1299. Replace Elements with Greatest Element on Right Side
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
 */
public class ReplaceElements {
    public int[] replaceElements(int[] arr) {
        for(int i=0; i<arr.length-1; i++){
            int max=0;
            for(int k=i+1; k<arr.length; k++){
                if(arr[k] > max) max = arr[k];
            }
            arr[i] = max;
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}
