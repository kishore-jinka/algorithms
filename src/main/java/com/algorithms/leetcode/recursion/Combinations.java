package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * https://leetcode.com/problems/combinations/
 * https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798/
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        if(n<=0 || k<=0 || n<k) return listOfLists;
        List<Integer> list = new ArrayList<Integer>();
        combineRecursive(n, k, 1, list, listOfLists);
        return listOfLists;
    }

    private void combineRecursive(int n, int k, int start, List<Integer> list, List<List<Integer>> listOfLists){
        if(k == 0){
            listOfLists.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=start; i<=n; i++){
            list.add(i);
            combineRecursive(n, k-1, i+1, list, listOfLists);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        Combinations combinations = new Combinations();
        List<List<Integer>> listOfLists = combinations.combine(4, 2);
        System.out.println("size of listOfLists: " + listOfLists.size());
        for(List<Integer> list : listOfLists){
            System.out.println(list);
        }
    }

}
