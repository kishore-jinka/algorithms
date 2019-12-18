package com.algorithms.leetcode.trees;

/**
 *
 * TODO: INCOMPLETE
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeInAndPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildSubTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildSubTree(int[] inorder, int inorderStartIndex, int inorderEndIndex, int[] postorder, int postorderStartIndex, int postorderEndIndex){
        TreeNode root = null;
        int rootValue = postorder[postorderEndIndex];
        root = new TreeNode(rootValue);
        int inorderIndexOfRoot = findIndex(inorder, rootValue);
        int lstInorderStartIndex = inorderStartIndex;
        int lstInorderEndIndex = inorderIndexOfRoot-1;
        int lstPostorderStartIndex = postorderStartIndex;
        int lstPostorderEndIndex = inorderIndexOfRoot-1;

        int rstInorderStartIndex = inorderIndexOfRoot+1;
        int rstInorderEndIndex = inorderEndIndex;
        int rstPostorderStartIndex = lstPostorderEndIndex+1;
        int rstPostorderEndIndex = postorderEndIndex-1;

        TreeNode leftSubTreeRoot = null;
        if(lstInorderEndIndex >= lstInorderStartIndex && lstPostorderEndIndex >=lstPostorderStartIndex)
            leftSubTreeRoot = buildSubTree(inorder, lstInorderStartIndex, lstInorderEndIndex, postorder, lstPostorderStartIndex, lstPostorderEndIndex);
        TreeNode rightSubTreeRoot = null;
        if(rstInorderEndIndex >= rstInorderStartIndex && rstPostorderEndIndex >=rstPostorderStartIndex)
            rightSubTreeRoot = buildSubTree(inorder, rstInorderStartIndex, rstInorderEndIndex, postorder, rstPostorderStartIndex, rstPostorderEndIndex);
        root.left = leftSubTreeRoot;
        root.right = rightSubTreeRoot;
        return root;
    }

    private int findIndex(int[] someorder, int value){
        for(int i=0;i<someorder.length; i++){
            if(someorder[i] == value) return i;
        }
        return -1;
    }
}
