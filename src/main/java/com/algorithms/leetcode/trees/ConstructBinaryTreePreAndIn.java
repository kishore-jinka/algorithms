package com.algorithms.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

public class ConstructBinaryTreePreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        return constructRecursive(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode constructRecursive(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap){
        if(preStart > preEnd){
            return null;
        }else if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderRootIndex = inorderMap.get(preorder[preStart]);
        int numberLeft = inorderRootIndex - inStart;
        root.left = constructRecursive(preorder, preStart + 1, preStart + numberLeft, inorder, inStart, inorderRootIndex - 1, inorderMap);
        root.right = constructRecursive(preorder, preStart + numberLeft + 1, preEnd, inorder, inorderRootIndex + 1, inEnd, inorderMap);
        return root;
    }
}
