package com.algorithms.leetcode.trees;

/**
 * 250. Count Univalue Subtrees
 * https://leetcode.com/problems/count-univalue-subtrees/
 */
public class CountUnivalueSubtrees {

    public int countUnivalSubtrees(TreeNode root) {
        Counter counter = new Counter();
        countUnivalueSubtreesRecursive(root, counter);
        return counter.counterValue;
    }

    private boolean countUnivalueSubtreesRecursive(TreeNode node, Counter counter){
        if(node == null) return true;
        boolean isLeftSame = countUnivalueSubtreesRecursive(node.left, counter);
        boolean isRightSame = countUnivalueSubtreesRecursive(node.right, counter);
        if(!isLeftSame || !isRightSame){
            return false;
        }
        if(node.left != null && node.val != node.left.val){
            return false;
        }
        if(node.right != null && node.val != node.right.val){
            return false;
        }
        counter.counterValue++;
        return true;
    }

    private class Counter{
        int counterValue=0;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node5_1 = new TreeNode(5);
        TreeNode node5_2 = new TreeNode(5);
        TreeNode node5_3 = new TreeNode(5);
        TreeNode node5_4 = new TreeNode(5);
        TreeNode node5_5 = new TreeNode(5);
        node5_1.left = node1;
        node5_1.right = node5_2;
        node1.left = node5_3;
        node1.right = node5_4;
        node5_2.right = node5_5;
        CountUnivalueSubtrees countUnivalueSubtrees = new CountUnivalueSubtrees();
        System.out.println(countUnivalueSubtrees.countUnivalSubtrees(node5_1));
    }

}
