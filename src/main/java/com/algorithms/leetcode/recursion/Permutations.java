package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2903/
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        if(nums.length == 0) return  permutations;
        List<Integer> slate = new ArrayList<Integer>();
        boolean[] isUsed = new boolean[nums.length];
        permuteRecursively(slate, isUsed, nums, permutations);
        return permutations;
    }

    private void permuteRecursively(List<Integer> slate, boolean[] isUsed, int[] nums, List<List<Integer>> permutations){
        if(slate.size() == nums.length){
            permutations.add(new ArrayList<Integer>(slate));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!isUsed[i]) {
                slate.add(nums[i]);
                isUsed[i] = true;
                permuteRecursively(slate, isUsed, nums, permutations);
                slate.remove(slate.size() - 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> permutationList = permutations.permute(nums);
        for(List<Integer> list : permutationList){
            System.out.println(list);
        }
    }
}
