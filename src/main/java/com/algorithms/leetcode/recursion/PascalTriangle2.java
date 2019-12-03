package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0) return new ArrayList<Integer>();
        Integer[] array = {1};
        List list = Arrays.asList(array);
        if(rowIndex == 0) return list;
        return generate(list, rowIndex, 1);
    }

    private List<Integer> generate(List<Integer> list, int rowIndex, int currentRowNumber){
        if(currentRowNumber > rowIndex){
            return list;
        }
        List<Integer> currentList = new ArrayList<Integer>();
        for(int i=0; i<=list.size(); i++){
            if(i == 0 || i == list.size()){
                currentList.add(i, 1);
            } else {
                currentList.add(i, list.get(i-1) + list.get(i));
            }
        }
        return generate(currentList, rowIndex, currentRowNumber + 1);
    }


    public static void main(String[] args){
        PascalTriangle2 pt2 = new PascalTriangle2();
        List<Integer> list = pt2.getRow(3);
        System.out.println(list);
    }
}

/*
Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 */
