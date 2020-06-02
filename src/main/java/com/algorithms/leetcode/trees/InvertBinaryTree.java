package com.algorithms.leetcode.trees;

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode dummy = root.right;
        root.right = root.left;
        root.left = dummy;
        root.right = invertTree(root.right);
        root.left = invertTree(root.left);
        return root;
    }
}
