package com.algorithms.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/
 */
public class KthSmallestElementInBST {

    /*
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
    */

    private int kthSmallesInt = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        dfs(root, 0, k);
        return kthSmallesInt;
    }

    private int dfs(TreeNode node, int numberOfPredecessors, int k){
        if(node.left == null && node.right == null){
            numberOfPredecessors = numberOfPredecessors + 1;
            if(numberOfPredecessors == k){
                kthSmallesInt = node.val;
            }
            return numberOfPredecessors;
        }

        if(node.left != null) numberOfPredecessors = dfs(node.left, numberOfPredecessors, k);

        numberOfPredecessors = numberOfPredecessors + 1;
        if(numberOfPredecessors == k){
            kthSmallesInt = node.val;
        }

        if(node.right != null) numberOfPredecessors = dfs(node.right, numberOfPredecessors, k);

        return  numberOfPredecessors;
    }
}
