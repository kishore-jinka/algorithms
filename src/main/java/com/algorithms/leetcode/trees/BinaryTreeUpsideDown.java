package com.algorithms.leetcode.trees;

/**
 * 156. Binary Tree Upside Down
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
public class BinaryTreeUpsideDown {

    TreeNode globalNode = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        dfs(root, null, null);
        return globalNode;
    }

    private void dfs(TreeNode node, TreeNode parent, TreeNode rightSibling){
        TreeNode oldLeft = node.left;
        TreeNode oldRight = node.right;
        node.right = parent;
        node.left = rightSibling;

        if(oldLeft == null && oldRight == null) globalNode = node;
        if(oldLeft != null) dfs(oldLeft, node, oldRight);
    }
}
