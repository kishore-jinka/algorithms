package com.algorithms.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662. Maximum Width of Binary Tree
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class MaxWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<RankNode> queue = new LinkedList<RankNode>();
        int maxWidth = 1;
        queue.add(new RankNode(root,1));
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            int leftMostRank = 0;
            int rightMostRank = 0;
            for(int i=0; i<numberOfNodes; i++){
                RankNode rankNode = queue.poll();
                if(i==0) leftMostRank = rankNode.rank;
                if(i==numberOfNodes-1) rightMostRank = rankNode.rank;
                if(rankNode.getTreeNode().left != null){
                    queue.add(new RankNode(rankNode.getTreeNode().left, rankNode.getRank()*2));
                }
                if(rankNode.getTreeNode().right != null){
                    queue.add(new RankNode(rankNode.getTreeNode().right, rankNode.getRank()*2 + 1));
                }
            }
            if(maxWidth < rightMostRank - leftMostRank + 1) maxWidth = rightMostRank - leftMostRank + 1;

        }
        return maxWidth;
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
