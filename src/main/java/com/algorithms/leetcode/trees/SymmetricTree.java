package com.algorithms.leetcode.trees;

import java.util.*;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricRecursive(root.left, root.right);
    }

    private boolean isSymmetricRecursive(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }
        return p.val == q.val
                && isSymmetricRecursive(p.left, q.right)
                && isSymmetricRecursive(p.right, q.left);
    }

    public static void main(String[] args){
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node2_2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node3_1 = new TreeNode(3);
        TreeNode node3_2 = new TreeNode(3);
        node1.left = node2_1;
        node1.right = node2_2;
        node2_1.left = node3_1;
        node2_1.right = node4_1;
        node2_2.left = node4_2;
        node2_2.right = node3_2;
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(node1));
    }
}

