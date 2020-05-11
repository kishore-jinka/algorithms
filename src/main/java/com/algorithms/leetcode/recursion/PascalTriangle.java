package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        if(numRows < 1) return new ArrayList<List<Integer>>();
        Integer[] array1 = {1};
        List list1 = Arrays.asList(array1);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(list1);
        generate(lists, numRows, 2);
        return lists;
    }

    private void generate(List<List<Integer>> lists, int totalRows, int currentRowNumber){
        if(currentRowNumber > totalRows){
            return;
        }
        List<Integer> previousList = lists.get(lists.size() -1);
        List<Integer> currentList = new ArrayList<Integer>();
        for(int i=0; i<=previousList.size(); i++){
            if(i == 0 || i == previousList.size()){
                currentList.add(i, 1);
            } else {
               currentList.add(i, previousList.get(i-1) + previousList.get(i));
            }
        }
        lists.add(currentList);
        generate(lists, totalRows, currentRowNumber + 1);
    }


    public static void main(String[] args){
        PascalTriangle pt = new PascalTriangle();
        List<List<Integer>> lists = pt.generate(5);
        for(List list : lists){
            System.out.println(list);
        }
    }
}

/*
Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
