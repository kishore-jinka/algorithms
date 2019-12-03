package com.algorithms.ik.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeToCircularDLL {

    static TreeNode BTtoLL(TreeNode root){
        List<TreeNode> inOrderedList = new ArrayList<TreeNode>();
        inOrderTraversalRecurisve(root, inOrderedList);
        if(inOrderedList.isEmpty()) return null;
        if(inOrderedList.size() == 1) return inOrderedList.get(0);
        convertInOrderedListToDLL(inOrderedList);
        return inOrderedList.get(0);
    }

    private static void inOrderTraversalRecurisve(TreeNode root, List<TreeNode> inOrderedList) {
        if(root == null) return;
        if(root.left_ptr != null) inOrderTraversalRecurisve(root.left_ptr, inOrderedList);
        inOrderedList.add(root);
        if(root.right_ptr != null) inOrderTraversalRecurisve(root.right_ptr, inOrderedList);
    }

    private static void convertInOrderedListToDLL(List<TreeNode> inOrderedList){
        for(int i=0; i<inOrderedList.size()-1; i++){
            TreeNode leftNode = inOrderedList.get(i);
            TreeNode rightNode = inOrderedList.get(i+1);
            leftNode.right_ptr = rightNode;
            rightNode.left_ptr = leftNode;
        }
        TreeNode headNode = inOrderedList.get(0);
        TreeNode lastNode = inOrderedList.get(inOrderedList.size()-1);
        lastNode.right_ptr = headNode;
        headNode.left_ptr = lastNode;
    }

    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();
        node1.val = 1;
        TreeNode node2 = new TreeNode();
        node2.val = 2;
        TreeNode node3 = new TreeNode();
        node3.val = 3;
        TreeNode node4 = new TreeNode();
        node4.val = 4;
        TreeNode node5 = new TreeNode();
        node5.val = 5;
        node2.left_ptr = node1;
        node2.right_ptr = node3;
        node4.left_ptr = node2;
        node4.right_ptr = node5;

        TreeNode dllHead = BTtoLL(node4);
        TreeNode nodeToRight = dllHead;
        System.out.println(nodeToRight.val);
        nodeToRight = nodeToRight.right_ptr;
        while(nodeToRight.val != dllHead.val){
            System.out.println(nodeToRight.val);
            nodeToRight = nodeToRight.right_ptr;
        }

        TreeNode nodeToLeft = dllHead.left_ptr;
        System.out.println(nodeToLeft.val);
        nodeToLeft = nodeToLeft.left_ptr;
        while(nodeToLeft.val != dllHead.left_ptr.val){
            System.out.println(nodeToLeft.val);
            nodeToLeft = nodeToLeft.left_ptr;
        }

    }
}
