package com.algorithms.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Name: LeetCode 637. Average of Levels in Binary Tree
 * Description:
 * Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * Label: IK Recommended LeetCode
 * Author: Kishore Jinka
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Double> averageList = new ArrayList<Double>();
        if(root == null) return averageList;
        queue.add(root);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            double total = 0.0d;
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                total = total + node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            averageList.add(total/numberOfNodes);
        }
        return averageList;
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
        AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree = new AverageOfLevelsInBinaryTree();
        List<Double> averageOfLevels = averageOfLevelsInBinaryTree.averageOfLevels(node2);
        System.out.println(averageOfLevels);
    }
}
