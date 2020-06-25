package com.algorithms.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int totalRows = triangle.size();
        int[][] minPath = new int[totalRows][triangle.get(totalRows - 1).size()];
        minPath[0][0] = triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++){
            List<Integer> triangleRow = triangle.get(i);
            for(int j=0;j<=i; j++){
                int min = 0;//minPath[i-1][j];
                if(j==0){
                    min = minPath[i-1][0];
                }else if(j>0 && j<i){
                    min = Math.min(minPath[i-1][j-1], minPath[i-1][j]);
                }else{
                    min = minPath[i-1][j-1];
                }
                minPath[i][j] = min + triangleRow.get(j);
            }
        }
        int min = minPath[totalRows - 1][0];
        for(int i=1; i<minPath[totalRows - 1].length; i++){
            min = Math.min(min, minPath[totalRows - 1][i]);
        }
        return min;
    }

    public static void main(String[] args){
        List<List<Integer>> triangleList = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList();
        list1.add(2);
        triangleList.add(list1);
        List<Integer> list2 = new ArrayList();
        list2.add(3);
        list2.add(4);
        triangleList.add(list2);
        List<Integer> list3 = new ArrayList();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangleList.add(list3);
        List<Integer> list4 = new ArrayList();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangleList.add(list4);
        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(triangleList));
    }
}
