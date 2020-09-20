package com.algorithms.leetcode.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeInAndPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null || postorder.length != inorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        return constructRecursive(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode constructRecursive(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap){
        if(postStart > postEnd){
            return null;
        }else if(postStart == postEnd){
            return new TreeNode(postorder[postEnd]);
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inorderRootIndex = inorderMap.get(root.val);
        int numberLeft = inorderRootIndex - inStart;
        root.left = constructRecursive(postorder, postStart, postStart + numberLeft - 1, inorder, inStart, inorderRootIndex - 1, inorderMap);
        root.right = constructRecursive(postorder, postStart + numberLeft, postEnd - 1, inorder, inorderRootIndex + 1, inEnd, inorderMap);
        return root;
    }
}
