package com.algorithms.trees;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return hasPathSumDFS(root, sum, 0);
    }

    private boolean hasPathSumDFS(TreeNode root, int sum, int sumSoFar){
        sumSoFar = sumSoFar + root.val;
        boolean leftChildIsTarget = false;
        boolean rightChildIsTarget = false;
        if(root.left == null && root.right == null){
            if(sumSoFar == sum) return true;
        }
        if(root.left != null){
           leftChildIsTarget =  hasPathSumDFS(root.left, sum, sumSoFar);
        }
        if(root.right != null){
            rightChildIsTarget = hasPathSumDFS(root.right, sum, sumSoFar);
        }
        return leftChildIsTarget || rightChildIsTarget;
    }


    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node5.left = node4_1;
        node5.right = node8;
        node4_1.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node4_2;
        node4_2.right = node1;
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(node5, 27));
        System.out.println(pathSum.hasPathSum(node5, 10));
    }

}


/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.


        Note: A leaf is a node with no children.

        Example:

        Given the below binary tree and sum = 22,

        5
        / \
        4   8
        /   / \
        11  13  4
        /  \      \
        7    2      1
        return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/