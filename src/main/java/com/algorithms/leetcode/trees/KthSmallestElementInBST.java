package com.algorithms.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/
 */
public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrderedList = new ArrayList<Integer>();
        if(root == null) return -1;
        inOrderTraversalRecursive(root, inOrderedList);
        if(inOrderedList.size()<k) return -1;
        return inOrderedList.get(k-1);
    }

    private void inOrderTraversalRecursive(TreeNode root, List<Integer> inOrderedList){
        if(root.left != null) inOrderTraversalRecursive(root.left, inOrderedList);
        inOrderedList.add(root.val);
        if(root.right != null) inOrderTraversalRecursive(root.right, inOrderedList);
    }
}
