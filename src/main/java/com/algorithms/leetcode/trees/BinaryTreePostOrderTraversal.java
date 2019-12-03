package com.algorithms.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderedList = new ArrayList<Integer>();
        if(root == null) return postOrderedList;
        postOrderTraversalRecursive(root, postOrderedList);
        return postOrderedList;
    }

    private void postOrderTraversalRecursive(TreeNode root, List<Integer> postOrderedList){
        if(root.left != null) postOrderTraversalRecursive(root.left, postOrderedList);
        if(root.right != null) postOrderTraversalRecursive(root.right, postOrderedList);
        postOrderedList.add(root.val);
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
        BinaryTreePostOrderTraversal binaryTreePostOrderRecursion = new BinaryTreePostOrderTraversal();
        List<Integer> postOrderTraversal = binaryTreePostOrderRecursion.postorderTraversal(node2);
        System.out.println(postOrderTraversal);
    }


}
