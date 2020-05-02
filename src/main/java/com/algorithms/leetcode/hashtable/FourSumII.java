package com.algorithms.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 454. Four Sum II
 * https://leetcode.com/problems/4sum-ii/
 * https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1134/
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0) return 0;
        Map<Integer, List<Couple>> mapAB = new HashMap();
        for(int indexA=0; indexA<A.length; indexA++){
            for(int indexB=0; indexB<B.length; indexB++) {
                Integer sum = A[indexA] + B[indexB];
                if (mapAB.get(sum) == null) {
                    mapAB.put(sum, new ArrayList<Couple>());
                }
                mapAB.get(sum).add(new Couple(indexA, indexB));
            }
        }
        int total = 0;
        for(int indexC=0; indexC<C.length; indexC++){
            for(int indexD=0; indexD<D.length; indexD++) {
                Integer sum = C[indexC] + D[indexD];
                List<Couple> listAB = mapAB.get(-1*sum);
                if(listAB != null) total = total + listAB.size();
            }
        }
        return total;
    }

    private class Couple{
        int first;
        int second;
        Couple(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args){
        int[] A = {1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        FourSumII fourSumII = new FourSumII();
        System.out.println(fourSumII.fourSumCount(A, B, C, D));
    }
}
