package com.algorithms.leetcode.trees;

import java.util.List;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null) return isBalanced;
        dfs(root);
        return isBalanced;
    }

    private int dfs(TreeNode node){
        int height = 0;
        if(node.left == null && node.right == null){
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if(node.left != null) leftHeight = 1 + dfs(node.left);
        if(node.right != null) rightHeight = 1 + dfs(node.right);
        height = Math.max(leftHeight, rightHeight);
        if(Math.abs(leftHeight - rightHeight) > 1){
            isBalanced = false;
        }
        return height;
    }

    public static void main(String[] args){
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        boolean isBalanced = balancedBinaryTree.isBalanced(node3);
        System.out.println(isBalanced);
    }
}
