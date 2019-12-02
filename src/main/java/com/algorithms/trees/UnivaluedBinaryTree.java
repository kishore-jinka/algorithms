package com.algorithms.trees;

/**
 * Name: LeetCode 965. Univalued Binary Tree
 * Description: A binary tree is univalued if every node in the tree has the same value.
 *              Return true if and only if the given tree is univalued.
 * Link: https://leetcode.com/problems/univalued-binary-tree/
 * Label: IK Recommended LeetCode
 * Author: Kishore Jinka
 */
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return false;
        return isUnivalTreeRecursive(root);
    }

    private boolean isUnivalTreeRecursive(TreeNode node){
        if(node == null) return true;
        boolean isLeftTreeUnival = isUnivalTreeRecursive(node.left);
        boolean isRightTreeUnival = isUnivalTreeRecursive(node.right);
        if(!isLeftTreeUnival || !isRightTreeUnival) return false;
        if(node.left != null && node.val != node.left.val) return false;
        if(node.right != null && node.val != node.right.val) return false;
        return true;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node5_1 = new TreeNode(5);
        TreeNode node5_2 = new TreeNode(5);
        TreeNode node5_3 = new TreeNode(5);
        TreeNode node5_4 = new TreeNode(5);
        TreeNode node5_5 = new TreeNode(5);
        node5_1.left = node1;
        node5_1.right = node5_2;
        node1.left = node5_3;
        node1.right = node5_4;
        node5_2.right = node5_5;
        UnivaluedBinaryTree univaluedBinaryTree = new UnivaluedBinaryTree();
        System.out.println(univaluedBinaryTree.isUnivalTree(node5_1));
    }
}
