package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
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
            list.add(internalList);
        }
        return list;
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
        BinaryTreeLevelOrderTraversal btBFS = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> levelOrderedList2 = btBFS.levelOrder(node2);
        System.out.println(levelOrderedList2);
    }
}
