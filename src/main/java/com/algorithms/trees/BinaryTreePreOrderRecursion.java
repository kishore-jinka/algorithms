package com.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderRecursion {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderedList = new ArrayList<Integer>();
        if(root == null) return preOrderedList;
        preOrderTraversalRecursive(root, preOrderedList);
        return preOrderedList;
    }

    private void preOrderTraversalRecursive(TreeNode root, List<Integer> preOrderedList){
        preOrderedList.add(root.val);
        if(root.left != null) preOrderTraversalRecursive(root.left, preOrderedList);
        if(root.right != null) preOrderTraversalRecursive(root.right, preOrderedList);
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
        BinaryTreePreOrderRecursion binaryTreePreOrderRecursion = new BinaryTreePreOrderRecursion();
        List<Integer> preorderTraversal = binaryTreePreOrderRecursion.preorderTraversal(node2);
        System.out.println(preorderTraversal);
    }


}
