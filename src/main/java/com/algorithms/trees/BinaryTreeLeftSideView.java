package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Name: Binary Tree Left Side View
 * Description: This problem is not asked in Leetcode.  But this is similar to 199. Binary Tree Right Side View
 * Link: None
 * Label: None
 * Author: Kishore Jinka
 */
public class BinaryTreeLeftSideView {
    public List<Integer> leftSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return new ArrayList();
        queue.add(root);
        List<Integer> leftSideViewList = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                if(i==0) leftSideViewList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return leftSideViewList;
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
        BinaryTreeLeftSideView leftSideView = new BinaryTreeLeftSideView();
        List<Integer> leftSideNodes = leftSideView.leftSideView(node2);
        System.out.println(leftSideNodes);
    }
}
