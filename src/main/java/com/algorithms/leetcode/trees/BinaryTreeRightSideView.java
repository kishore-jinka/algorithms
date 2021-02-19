package com.algorithms.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/submissions/
 */
public class BinaryTreeRightSideView {


    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return new ArrayList();
        queue.add(root);
        List<Integer> rightSideViewList = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                if(i==numberOfNodes-1) rightSideViewList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return rightSideViewList;
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

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;

        BinaryTreeRightSideView rightSideView = new BinaryTreeRightSideView();
        List<Integer> rightSideNodes = rightSideView.rightSideView(node2);
        System.out.println(rightSideNodes);
    }
}



