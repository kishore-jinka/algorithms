package com.algorithms.others.trees;

import com.algorithms.leetcode.trees.TreeNode;

public class LongestConsecutiveSequence {

    public int longestConsecutiveDFS(TreeNode root) {
        if(root == null) return 0;
        return getLongestConsecutiveDFS(root, 0, Integer.MIN_VALUE);
    }

    private int getLongestConsecutiveDFS(TreeNode root, int lengthSoFar, int lastInt){
        //sumSoFar = sumSoFar + root.val;
        if(lastInt == Integer.MIN_VALUE) lengthSoFar = 1;
        if(lastInt == root.val + 1) lengthSoFar = lengthSoFar + 1;
        int leftChildLengthSoFar = 0;
        int rightChildLengthSoFar = 0;
        if(root.left == null && root.right == null){
            return lengthSoFar;
        }
        if(root.left != null){
            leftChildLengthSoFar =  getLongestConsecutiveDFS(root.left, lengthSoFar, root.val);
        }
        if(root.right != null){
            rightChildLengthSoFar = getLongestConsecutiveDFS(root.right, lengthSoFar, root.val);
        }
        return Math.max(leftChildLengthSoFar, rightChildLengthSoFar);
    }


    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node3;
        node3.left = node2;
        node3.right = node4;
        node4.right = node5;
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutiveDFS(node1));
    }

}


/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:

Input:

   2
    \
     3
    /
   2
  /
 1

Output: 2

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
*/