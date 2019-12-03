package com.algorithms.ik.trees;

import com.algorithms.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderRecursion {
    public List<List<Integer>> levelOrder(com.algorithms.leetcode.trees.TreeNode root) {
        List<List<Integer>> levelOrderedList = new ArrayList<List<Integer>>();
        if(root == null) return levelOrderedList;
        List<com.algorithms.leetcode.trees.TreeNode> rootNodeList = new ArrayList<com.algorithms.leetcode.trees.TreeNode>();
        rootNodeList.add(root);
        levelOrderTraversalRecursive(rootNodeList, levelOrderedList);
        return levelOrderedList;
    }

    private void levelOrderTraversalRecursive(List<com.algorithms.leetcode.trees.TreeNode> currentNodes, List<List<Integer>> levelOrderedList){
        if(currentNodes.size() == 0) return;
        List<Integer> currentIntegersList = new ArrayList<Integer>();
        List<com.algorithms.leetcode.trees.TreeNode> nextNodes = new ArrayList<com.algorithms.leetcode.trees.TreeNode>();
        for(com.algorithms.leetcode.trees.TreeNode treeNode : currentNodes){
            currentIntegersList.add(treeNode.val);
            if(treeNode.left != null) nextNodes.add(treeNode.left);
            if(treeNode.right != null) nextNodes.add(treeNode.right);
        }
        levelOrderedList.add(currentIntegersList);
        levelOrderTraversalRecursive(nextNodes, levelOrderedList);
    }

    public static void main(String[] args){
        com.algorithms.leetcode.trees.TreeNode node2 = new com.algorithms.leetcode.trees.TreeNode(2);
        com.algorithms.leetcode.trees.TreeNode node1 = new com.algorithms.leetcode.trees.TreeNode(1);
        com.algorithms.leetcode.trees.TreeNode node4 = new com.algorithms.leetcode.trees.TreeNode(4);
        com.algorithms.leetcode.trees.TreeNode node3 = new com.algorithms.leetcode.trees.TreeNode(3);
        com.algorithms.leetcode.trees.TreeNode node6 = new com.algorithms.leetcode.trees.TreeNode(6);
        com.algorithms.leetcode.trees.TreeNode node7 = new com.algorithms.leetcode.trees.TreeNode(7);
        com.algorithms.leetcode.trees.TreeNode node5 = new TreeNode(5);
        node2.left = node1;
        node2.right = node4;
        node4.left = node3;
        node4.right = node6;
        node6.right = node7;
        node3.right = node5;
        BinaryTreeLevelOrderRecursion binaryTreeLevelOrderRecursion = new BinaryTreeLevelOrderRecursion();
        List<List<Integer>> levelOrderedList = binaryTreeLevelOrderRecursion.levelOrder(node2);
        System.out.println(levelOrderedList);
    }
}

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
