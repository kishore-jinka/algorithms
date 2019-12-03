package com.algorithms.ik.trees;

import java.util.ArrayList;
import java.util.List;

public class CheckBST {

    static boolean isBST(TreeNode root){
        if(root == null) return false;
        List<Integer> list = new ArrayList<Integer>();
        inOrderedRecursiveTravel(root, list);
        if(list.size() == 1) return true;
        for(int i=1; i<list.size(); i++){
            if(list.get(i) < list.get(i-1)) return false;
        }
        return true;
    }

    static void inOrderedRecursiveTravel(TreeNode root, List<Integer> list){
        if(root.left_ptr != null) inOrderedRecursiveTravel(root.left_ptr, list);
        list.add(root.val);
        if(root.right_ptr != null) inOrderedRecursiveTravel(root.right_ptr, list);
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode();
        node1.val = 1;
        TreeNode node2 = new TreeNode();
        node2.val = 2;
        TreeNode node3 = new TreeNode();
        node3.val = 3;
        node2.left_ptr = node1;
        node2.right_ptr = node3;
        System.out.println(isBST(node2));
    }

    private static class TreeNode{
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;
    }
}
