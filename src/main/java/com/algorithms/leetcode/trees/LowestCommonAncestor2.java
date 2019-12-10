package com.algorithms.leetcode.trees;

/**
 * Return the parent node of Lowest Common Ancestor of a Binary Tree as defined in 236, otherwise null
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode parentNode, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return parentNode;
        TreeNode leftLCA2 = lowestCommonAncestor(root.left, root, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, root, p, q);
        if(leftLCA2 != null && rightLCA != null) return parentNode;
        return leftLCA2 != null ? leftLCA2 : rightLCA;
    }

    public static void main(String[] args){
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node5 = new TreeNode(5);
        node2.left = node1;
        node2.right = node4;
        node4.left = node3;
        node4.right = node6;
        node6.right = node7;
        node3.right = node5;
        LowestCommonAncestor2 leastCommonAncestor = new LowestCommonAncestor2();
        TreeNode lcaNode = leastCommonAncestor.lowestCommonAncestor(node2, null, node5, node7);
        System.out.println(lcaNode.val);
    }
}
