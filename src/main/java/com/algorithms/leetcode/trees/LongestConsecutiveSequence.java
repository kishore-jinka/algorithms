package com.algorithms.leetcode.trees;

/**
 * 298. Binary Tree Longest Consecutive Sequence
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    private int maxLength;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.right != null) longestConsecutiveRecursive(root.right, root.val, 1);
        if(root.left != null) longestConsecutiveRecursive(root.left, root.val, 1);
        return maxLength;
    }

    private void longestConsecutiveRecursive(TreeNode root, int previousValue, int lengthSoFar){
        if(root.val == previousValue + 1){
            lengthSoFar++;
        }else{
            lengthSoFar = 1;
        }
        if(lengthSoFar > maxLength) maxLength = lengthSoFar;
        if(root.right != null) longestConsecutiveRecursive(root.right, root.val, lengthSoFar);
        if(root.left != null) longestConsecutiveRecursive(root.left, root.val, lengthSoFar);
    }
}
