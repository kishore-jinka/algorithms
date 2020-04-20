package com.algorithms.leetcode.arrays;

import java.util.Arrays;

/**
 * 1051. Height Checker
 * https://leetcode.com/problems/height-checker/
 * https://leetcode.com/explore/featured/card/fun-with-arrays/523/conclusion/3228/
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] original = new int[heights.length];
        for(int i=0; i<heights.length; i++){
            original[i] = heights[i];
        }
        Arrays.sort(heights);
        int height = 0;
        for(int i=0; i<heights.length; i++){
            if(original[i] != heights[i]) height = height + 1;
        }
        return height;
    }

    public static void main(String[] args){
        int[] heights = {1,1,4,2,1,3};
        HeightChecker heightChecker = new HeightChecker();
        System.out.println(heightChecker.heightChecker(heights));
    }
}
