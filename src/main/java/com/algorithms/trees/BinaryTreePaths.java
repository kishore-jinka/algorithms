package com.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        String pathString = "";
        List<String> list = new ArrayList<String>();
        binaryTreePathsRecursive(root, pathString, list);
        return list;
    }

    private void binaryTreePathsRecursive(TreeNode root, String pathString, List list){
        if(root == null) return;
        else{
            if(root.left == null && root.right == null){
                list.add(pathString+root.val);
                return;
            }
            if(root.left != null){
                binaryTreePathsRecursive(root.left, pathString+root.val+"->", list);
            }
            if(root.right != null){
                binaryTreePathsRecursive(root.right, pathString+root.val+"->", list);
            }
        }
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
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> binaryTreePathsList = binaryTreePaths.binaryTreePaths(node2);
        System.out.println(binaryTreePathsList);
    }

}
