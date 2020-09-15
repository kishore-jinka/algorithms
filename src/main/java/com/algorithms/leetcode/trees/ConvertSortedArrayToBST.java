package com.algorithms.leetcode.trees;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        TreeNode root = helper(nums, 0, nums.length-1);
        return root;
    }

    private TreeNode helper(int[] nums, int start, int end){
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }


}
