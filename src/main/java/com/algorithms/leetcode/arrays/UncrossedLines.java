package com.algorithms.leetcode.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1035. Uncrossed Lines
 * https://leetcode.com/problems/uncrossed-lines/
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/
 * TODO: Incomplete
 */
public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        if(A.length == 0 || B.length == 0) return 0;
        Map<Integer, LinkedList<Integer>> bMap = new HashMap<Integer, LinkedList<Integer>>();
        for(int i=0; i<B.length; i++){
            if(bMap.get(B[i]) == null){
                bMap.put(B[i], new LinkedList<Integer>());
            }
            List<Integer> bList = bMap.get(B[i]);
            bList.add(i);
        }
        Map<Integer, Integer> aMap = new HashMap<Integer, Integer>();
        int uncrossedLines = 0;
        for(int i=0; i<A.length; i++){
            if(bMap.get(A[i]) != null){
                List<Integer> bList = bMap.get(A[i]);

            }
        }
        return 0;
    }
}
