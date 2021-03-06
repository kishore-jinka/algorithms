package com.algorithms.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderedList = new ArrayList<Integer>();
        if(root == null) return inOrderedList;
        inOrderTraversalRecursive(root, inOrderedList);
        return inOrderedList;
    }

    private void inOrderTraversalRecursive(TreeNode root, List<Integer> inOrderedList){
        if(root.left != null) inOrderTraversalRecursive(root.left, inOrderedList);
        inOrderedList.add(root.val);
        if(root.right != null) inOrderTraversalRecursive(root.right, inOrderedList);
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
        BinaryTreeInOrderTraversal binaryTreeInOrderRecursion = new BinaryTreeInOrderTraversal();
        List<Integer> inOrderedList = binaryTreeInOrderRecursion.inorderTraversal(node2);
        System.out.println(inOrderedList);
    }
}