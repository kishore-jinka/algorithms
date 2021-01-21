package com.algorithms.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 545. Boundary of Binary Tree
 * https://leetcode.com/problems/boundary-of-binary-tree/
 * TODO: INCOMPLETE
 */
public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        Queue<RankNode> queue = new LinkedList();
        List<Integer> list = new ArrayList();
        if(root == null) return list;
        list.add(root.val);
        if(root.left != null) queue.add(new RankNode(root.left, 2));
        if(root.right != null) queue.add(new RankNode(root.right, 3));
        List<Integer> leftView = new ArrayList();
        List<Integer> rightView = new ArrayList();
        List<Integer> bottomView = null;
        int level = 1;
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            bottomView = new ArrayList();

            for(int i=0; i<numberOfNodes; i++){
                RankNode node = queue.poll();
                if(node.rank == 2*level) leftView.add(node.treeNode.val);
                if(node.rank > 2*level && node.rank < 4*level-1) bottomView.add(node.treeNode.val);
                if(node.rank == 4*level-1) rightView.add(0,node.treeNode.val);
                if(node.treeNode.left != null) queue.add(new RankNode(node.treeNode.left, node.rank * 2));
                if(node.treeNode.right != null) queue.add(new RankNode(node.treeNode.right, node.rank * 2 + 1));
            }

            level++;
        }
        list.addAll(leftView);
        list.addAll(bottomView);
        list.addAll(rightView);
        return list;
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

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        BoundaryOfBinaryTree boundaryOfBinaryTree = new BoundaryOfBinaryTree();
        List<Integer> boundary = boundaryOfBinaryTree.boundaryOfBinaryTree(node1);
        System.out.println(boundary);
    }
}
