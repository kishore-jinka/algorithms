package com.algorithms.leetcode.trees;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<List<Integer>> linkedList = new LinkedList<List<Integer>>();
        if(root == null) return linkedList;
        queue.add(root);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            List<Integer> internalList = new ArrayList<Integer>();
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                internalList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            linkedList.addFirst(internalList);
        }
        return linkedList;
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
        BinaryTreeLevelOrderTraversal2 btLevelOrderTraversal2 = new BinaryTreeLevelOrderTraversal2();
        List<List<Integer>> levelOrderedList2 = btLevelOrderTraversal2.levelOrderBottom(node2);
        System.out.println(levelOrderedList2);
    }
}

