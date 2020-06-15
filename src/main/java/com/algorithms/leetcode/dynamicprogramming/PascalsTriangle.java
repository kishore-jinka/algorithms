package com.algorithms.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<List<Integer>>();
        for(int row=0; row<numRows; row++){
            dp.add(new ArrayList());
            for(int column=0; column<row+1; column++){
                if(column == 0 || column == row){
                    dp.get(row).add(1);
                }else{
                    int sum = dp.get(row-1).get(column) + dp.get(row-1).get(column-1);
                    dp.get(row).add(sum);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args){
        PascalsTriangle pt = new PascalsTriangle();
        List<List<Integer>> lists = pt.generate(5);
        for(List list : lists){
            System.out.println(list);
        }
    }
}

/*
    //USING RECURSION
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
 */
