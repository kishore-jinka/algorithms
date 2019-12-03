package com.algorithms.leetcode.recursion;

import com.algorithms.leetcode.trees.TreeNode;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return getMaxDepth(root.left, root.right, 1);
    }

    private int getMaxDepth(TreeNode leftNode, TreeNode rightNode, int currentDepth){
        int leftMaxDepth = currentDepth;
        int rightMaxDepth = currentDepth;
        if(leftNode != null) leftMaxDepth = getMaxDepth(leftNode.left, leftNode.right, leftMaxDepth + 1);
        if(rightNode != null) rightMaxDepth = getMaxDepth(rightNode.left, rightNode.right, rightMaxDepth + 1);
        return Math.max(leftMaxDepth, rightMaxDepth);
    }

    public static void main(String[] args){
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        t3.left = t9;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;
        MaxDepthOfBinaryTree mdbt = new MaxDepthOfBinaryTree();
        System.out.println(mdbt.maxDepth(t3));
    }
}

/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.

*/
