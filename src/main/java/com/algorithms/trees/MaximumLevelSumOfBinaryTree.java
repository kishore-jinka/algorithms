package com.algorithms.trees;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Name: LeetCode 1161. Maximum Level Sum of a Binary Tree
 * Description: Given the root of a binary tree, the level of its root is 1,
 *              the level of its children is 2, and so on.
 *              Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 * Link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 * Label: IK Recommended LeetCode
 * Author: Kishore Jinka
 */
public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {
        int maxSumLevel = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return maxSumLevel;
        queue.add(root);
        int currentLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            int levelSum = Integer.MIN_VALUE;
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                if(i==0) {
                    levelSum = node.val;
                }else {
                    levelSum = levelSum + node.val;
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            currentLevel++;
            if(maxSum<levelSum){
                maxSum = levelSum;
                maxSumLevel = currentLevel;
            }
        }
        return maxSumLevel;
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
        MaximumLevelSumOfBinaryTree maximumLevelSumOfBinaryTree = new MaximumLevelSumOfBinaryTree();
        int maxLevelSum = maximumLevelSumOfBinaryTree.maxLevelSum(node2);
        System.out.println(maxLevelSum);
    }
}
