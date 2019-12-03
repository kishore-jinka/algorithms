package com.algorithms.ik.trees;

import com.algorithms.leetcode.trees.TreeNode;

/**
 * Name: Print All Paths of a Tree
 * Description: Given a binary tree. Returns all the paths from root to leaf of the tree.
 *              Each path will consist of a list of integer values denoting nodes traversed for that path
 * Link: None
 * Label: IK Practice Sheet
 * Author: Kishore Jinka
 */
public class BinaryTreePaths {

    static void printAllPathsDFS(com.algorithms.leetcode.trees.TreeNode root){
        String pathString = "";
        printAllPathsDFS(root, pathString);
    }

    static void printAllPathsDFS(com.algorithms.leetcode.trees.TreeNode root, String pathString){
        if(root == null) return;
        else{
            if(root.left == null && root.right == null){
                System.out.println(pathString + root.val);
                return;
            }
            if(root.left != null){
                printAllPathsDFS(root.left, pathString + root.val + " ");
            }
            if(root.right != null){
                printAllPathsDFS(root.right, pathString + root.val + " ");
            }
        }
    }


    public static void main(String[] args){
        com.algorithms.leetcode.trees.TreeNode node1 = new com.algorithms.leetcode.trees.TreeNode(1);
        com.algorithms.leetcode.trees.TreeNode node2 = new com.algorithms.leetcode.trees.TreeNode(2);
        com.algorithms.leetcode.trees.TreeNode node3 = new com.algorithms.leetcode.trees.TreeNode(3);
        com.algorithms.leetcode.trees.TreeNode node4 = new com.algorithms.leetcode.trees.TreeNode(4);
        com.algorithms.leetcode.trees.TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;
        node1.left = node2;
        node1.right = node3;

        printAllPathsDFS(node1);
    }

}
