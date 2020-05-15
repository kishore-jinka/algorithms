package com.algorithms.leetcode.trees;


/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}
