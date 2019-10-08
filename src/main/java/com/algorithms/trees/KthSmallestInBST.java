package com.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {

    static int kth_smallest_element(TreeNode root, int k) {
        if(root == null) return Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        inOrderedRecursiveTravel(root, list);
        if(k > list.size()) return Integer.MIN_VALUE;
        return list.get(k-1);
    }

    static void inOrderedRecursiveTravel(TreeNode root, List<Integer> list){
        if(root.left_ptr != null) inOrderedRecursiveTravel(root.left_ptr, list);
        list.add(root.val);
        if(root.right_ptr != null) inOrderedRecursiveTravel(root.right_ptr, list);
    }

    static class TreeNode
    {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val)
        {
            val = _val;
            left_ptr = null;
            right_ptr = null;
        }
    };

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left_ptr = node1;
        node2.right_ptr = node3;

        System.out.println(kth_smallest_element(node1, 3));
    }
}
