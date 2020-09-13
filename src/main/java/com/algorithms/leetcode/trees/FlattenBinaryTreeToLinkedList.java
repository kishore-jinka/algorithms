package com.algorithms.leetcode.trees;

/**
 * 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode dummy = new TreeNode(-1);
        TreeNode predecessor = dfs(root, dummy);
        root = predecessor.right;
    }

    private TreeNode dfs(TreeNode node, TreeNode predecessor){
        predecessor.right = node;
        predecessor = node;

        if(node.left != null) predecessor = dfs(node.left, predecessor);
        if(node.right != null) predecessor = dfs(node.right, predecessor);

        return predecessor;
    }
}
