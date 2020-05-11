package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0) return null;
        List<Integer> row = new ArrayList(rowIndex+1);
        row.add(0,1);
        if(rowIndex == 0){
            return row;
        }else if(rowIndex == 1){
            row.add(1, 1);
            return row;
        }
        List<Integer> previousRow = getRow(rowIndex-1);
        for(int i=1; i<rowIndex; i++){
            row.add(i, previousRow.get(i) + previousRow.get(i-1));
        }
        row.add(rowIndex, 1);
        return row;
    }

    public static void main(String[] args){
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        List<Integer> row = pascalsTriangleII.getRow(4);
        for(Integer i : row){
            System.out.println(i);
        }
    }
}
