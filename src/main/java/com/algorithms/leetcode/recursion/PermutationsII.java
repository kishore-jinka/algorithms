package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        if(nums.length == 0) return  permutations;
        List<Integer> slate = new ArrayList<Integer>();
        boolean[] isUsed = new boolean[nums.length];
        Set<List<Integer>> set = new HashSet();
        permuteRecursively(slate, isUsed, nums, permutations, set);
        return permutations;
    }

    private void permuteRecursively(List<Integer> slate, boolean[] isUsed, int[] nums, List<List<Integer>> permutations, Set set){
        if(slate.size() == nums.length){
            List<Integer> uniqueList = new ArrayList<Integer>(slate);
            if(set.add(uniqueList)) permutations.add(uniqueList);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!isUsed[i]) {
                slate.add(nums[i]);
                isUsed[i] = true;
                permuteRecursively(slate, isUsed, nums, permutations, set);
                slate.remove(slate.size() - 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args){
        PermutationsII permutationsII = new PermutationsII();
        int[] nums = {1,1,3};
        List<List<Integer>> uniquePermutations = permutationsII.permuteUnique(nums);
        for(List<Integer> list : uniquePermutations){
            System.out.println(list);
        }
    }
}
