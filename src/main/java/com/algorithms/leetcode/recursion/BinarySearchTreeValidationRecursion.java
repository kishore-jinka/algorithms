package com.algorithms.leetcode.recursion;

import com.algorithms.leetcode.trees.TreeNode;

//LeetCode passes 68/75 cases.  Something is wrong with the below code or LeetCode?
public class BinarySearchTreeValidationRecursion {

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBST(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }

    private boolean isValidBST(int floor, int ceiling, TreeNode root){
        boolean isRootValid = root.val < ceiling && root.val >= floor;
        boolean isLeftTreeBST = root.left == null || isValidBST(floor, root.val, root.left);
        boolean isRightTreeBST = root.right == null || isValidBST(root.val, ceiling, root.right);
        return isRootValid && isLeftTreeBST && isRightTreeBST;
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
        BinarySearchTreeValidationRecursion bstvr = new BinarySearchTreeValidationRecursion();
        System.out.println(bstvr.isValidBST(node2));
    }

}

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */