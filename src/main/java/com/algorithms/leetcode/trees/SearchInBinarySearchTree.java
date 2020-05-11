package com.algorithms.leetcode.trees;

/**
 * 700. Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233/
 */
public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(val == root.val){
            return root;
        }else if(val < root.val){
            return searchBST(root.left, val);
        }else if(val > root.val){
            return  searchBST(root.right, val);
        }
        return null;
    }
}
