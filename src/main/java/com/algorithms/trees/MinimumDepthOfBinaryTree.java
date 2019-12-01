package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Name: LeetCode 111. Minimum Depth of Binary Tree
 * Description: Given a binary tree, find its minimum depth.
 *              The minimum depth is the number of nodes along the shortest path
 *              from the root node down to the nearest leaf node.
 *              Note: A leaf is a node with no children.
 * Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Label: IK Recommended LeetCode
 * Author: Kishore Jinka
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        int minDepth = 0;
        if(root == null) return minDepth;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            boolean isThisLastLevel = false;
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    isThisLastLevel = true;
                    break;
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            minDepth++;
            if(isThisLastLevel) break;
        }
        return minDepth;
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
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        int minDepth = minimumDepthOfBinaryTree.minDepth(node2);
        System.out.println(minDepth);
    }

}
