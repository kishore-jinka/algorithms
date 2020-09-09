package com.algorithms.leetcode.trees;

/**
 * 563. Binary Tree Tilt
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {

    private int globalTilt;

    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return globalTilt;
    }

    private int dfs(TreeNode node){
        if(node.left == null && node.right == null) return node.val;
        int leftSum = 0;
        int rightSum = 0;
        if(node.left != null){
            leftSum = dfs(node.left);
        }
        if(node.right != null){
            rightSum = dfs(node.right);
        }
        globalTilt = globalTilt + Math.abs(leftSum - rightSum);
        return node.val + leftSum + rightSum;
    }
}
