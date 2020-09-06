package com.algorithms.leetcode.trees;

/**
 * 687. Longest Univalue Path
 * https://leetcode.com/problems/longest-univalue-path/
 */
public class LongestUnivaluePath {

    private int globalPath = 0;
    public int longestUnivaluePath(TreeNode root){
        if(root == null) return 0;
        dfs(root);
        return globalPath;
    }

    private int dfs(TreeNode node){
        int longestPath = 0;
        int longestVPath = 0;
        if(node.left == null && node.right == null) return 0;
        if(node.left != null){
            int longestLeftPath = dfs(node.left);
            if(node.val == node.left.val){
                longestPath = 1 + longestLeftPath;
                longestVPath = longestPath;
            }
        }
        if(node.right != null){
            int longestRightPath = dfs(node.right);
            if(node.val == node.right.val){
                longestPath = Math.max(longestPath, 1 + longestRightPath);
                longestVPath = longestVPath + 1 + longestRightPath;
            }
        }
        if(longestVPath > globalPath) globalPath = longestVPath;
        return longestPath;
    }
}
