package com.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Name: LeetCode 104. Maximum Depth of Binary Tree
 * Description: Given a binary tree, find its maximum depth.
 *              The maximum depth is the number of nodes along the longest path
 *              from the root node down to the farthest leaf node.
 *              Note: A leaf is a node with no children.
 * Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Label: IK Recommended LeetCode
 * Author: Kishore Jinka
 */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if(root == null) return maxDepth;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }

    public static void main(String[] args){
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node5 = new TreeNode(5);
        node2.left = node1;
        node2.right = node4;
        node4.left = node3;
        node4.right = node6;
        node6.right = node7;
        node3.right = node5;
        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
        int minDepth = maxDepthOfBinaryTree.maxDepth(node2);
        System.out.println(minDepth);
    }

}
