package com.algorithms.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 958. Check Completeness of a Binary Tree
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 */
public class CheckCompletenessOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return false;
        Queue<RankNode> queue = new LinkedList<RankNode>();
        int expectedRank = 1;
        queue.add(new RankNode(root,1));
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            for(int i=0; i<numberOfNodes; i++){
                RankNode rankNode = queue.poll();
                if(expectedRank != rankNode.rank) return false;
                expectedRank++;
                if(rankNode.getTreeNode().left != null){
                    queue.add(new RankNode(rankNode.getTreeNode().left, rankNode.getRank()*2));
                }
                if(rankNode.getTreeNode().right != null){
                    queue.add(new RankNode(rankNode.getTreeNode().right, rankNode.getRank()*2 + 1));
                }
            }

        }
        return true;
    }

    class RankNode{
        private TreeNode treeNode;
        private Integer rank;

        public RankNode(TreeNode treeNode, Integer rank) {
            this.treeNode = treeNode;
            this.rank = rank;
        }

        public TreeNode getTreeNode() {
            return treeNode;
        }

        public Integer getRank() {
            return rank;
        }
    }
}
