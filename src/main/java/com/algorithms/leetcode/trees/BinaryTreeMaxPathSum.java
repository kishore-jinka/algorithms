package com.algorithms.leetcode.trees;

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * TODO: INCOMPLETE
 */
public class BinaryTreeMaxPathSum {
    int globalMax = 0;
    public int maxPathSum(TreeNode root){
        if(root == null) return 0;
        dfs(root);
        return globalMax;
    }

    private int dfs(TreeNode node){
        int maxPathSum = node.val;
        int maxVPathSum = node.val;
        if(node.left == null && node.right == null) return node.val;
        if(node.left != null){
            int leftMax = dfs(node.left);
            maxPathSum = Math.max(maxPathSum, maxPathSum + leftMax);
            maxVPathSum = maxPathSum;
        }
        if(node.right != null){
            int rightMax = dfs(node.right);
            maxPathSum = Math.max(maxPathSum, node.val + rightMax);
            maxVPathSum = Math.max(maxVPathSum, node.val + rightMax);
            maxVPathSum = Math.max(maxVPathSum, maxVPathSum + rightMax);
        }
        if(maxVPathSum > globalMax) globalMax = maxVPathSum;
        return maxPathSum;
    }
}
