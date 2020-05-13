package com.algorithms.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> inOrderedList = new ArrayList<Integer>();
        inOrderTraversalRecursive(root, inOrderedList);
        for(int i=1; i<inOrderedList.size(); i++){
            if(inOrderedList.get(i) <= inOrderedList.get(i-1)) return false;
        }
        return true;
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
        ValidateBinarySearchTree bstvr = new ValidateBinarySearchTree();
        System.out.println(bstvr.isValidBST(node2));
    }

}

/*
    //LeetCode passes 68/75 cases.  Something is wrong with the below code or LeetCode?
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        return isValidBST2(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }

    private boolean isValidBST2(int floor, int ceiling, TreeNode root){
        if(root == null){
            return true;
        }else if(root.val >= ceiling || root.val <= floor){
            return false;
        }
        return isValidBST2(floor, root.val, root.left) && isValidBST2(root.val, ceiling, root.right);
    }
*/