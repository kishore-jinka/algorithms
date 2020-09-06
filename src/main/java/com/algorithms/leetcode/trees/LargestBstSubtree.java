package com.algorithms.leetcode.trees;

/**
 * 333. Largest BST Sub Tree
 * https://leetcode.com/problems/largest-bst-subtree/
 * TODO: Incomplete
 */
public class LargestBstSubtree {

    private int largestNodesSize = 1;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return largestNodesSize;
    }

    private Combo dfs(TreeNode node){
        int smallest = node.val;
        int largest = node.val;
        boolean isBst = true;
        int nodesSize = 1;
        if(node.left == null && node.right == null){
            return new Combo(smallest, largest, isBst, nodesSize);
        }
        if(node.left != null){
            Combo combo = dfs(node.left);
            smallest = Math.max(smallest, combo.smallest);
            largest = Math.max(largest, combo.largest);
            nodesSize = nodesSize + combo.nodesSize;
            if(!combo.isBst || combo.largest >= node.val){
                isBst = false;
            }
        }
        if(node.right != null){
            Combo combo = dfs(node.right);
            smallest = Math.max(smallest, combo.smallest);
            largest = Math.max(largest, combo.largest);
            nodesSize = nodesSize + combo.nodesSize;
            if(!combo.isBst || combo.smallest <= node.val){
                isBst = false;
            }
        }
        if(isBst && nodesSize > largestNodesSize) {
            largestNodesSize = nodesSize;
        }
        return new Combo(smallest, largest, isBst, nodesSize);
    }

    private class Combo{
        int smallest;
        int largest;
        boolean isBst;
        int nodesSize;
        Combo(int smallest, int largest, boolean isBst, int nodesSize){
            this.smallest = smallest;
            this.largest = largest;
            this.isBst = isBst;
            this.nodesSize = nodesSize;
        }
    }
}
