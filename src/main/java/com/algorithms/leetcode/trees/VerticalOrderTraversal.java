package com.algorithms.leetcode.trees;


import java.util.*;

/**
 *  314. Binary Tree Vertical Order Traversal
 *  https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 */
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        if(root == null) return finalList;
        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        List<List<Integer>> negativeList = new ArrayList<List<Integer>>();
        List<List<Integer>> positiveList = new ArrayList<List<Integer>>();
        List<Integer> zeroList = new LinkedList();
        QueueNode rootQNode = new QueueNode(root, 0);
        queue.add(rootQNode);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            for(int i=0; i<numberOfNodes; i++){
                QueueNode qNode = queue.poll();
                if(qNode.rank == 0){
                    zeroList.add(qNode.node.val);
                }else if(qNode.rank > 0){
                    int position = qNode.rank - 1;
                    if(position == positiveList.size()) positiveList.add(position, new LinkedList<Integer>());
                    positiveList.get(position).add(qNode.node.val);
                }else if(qNode.rank < 0){
                    int position = Math.abs(qNode.rank) - 1;
                    if(position == negativeList.size()) negativeList.add(position, new LinkedList<Integer>());
                    negativeList.get(position).add(qNode.node.val);
                }
                if(qNode.node.left != null) queue.add(new QueueNode(qNode.node.left, qNode.rank - 1));
                if(qNode.node.right != null) queue.add(new QueueNode(qNode.node.right, qNode.rank + 1));
            }
        }

        for(int i=negativeList.size() - 1; i>-1; i--){
            finalList.add(negativeList.get(i));
        }
        finalList.add(zeroList);
        for(int i=0; i<positiveList.size(); i++){
            finalList.add(positiveList.get(i));
        }
        return finalList;
    }

    private class QueueNode{
        TreeNode node;
        int rank;
        QueueNode(TreeNode node, int rank){
            this.node = node;
            this.rank = rank;
        }

        public TreeNode getNode(){
            return node;
        }

        public int getRank(){
            return rank;
        }
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
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
        List<List<Integer>> verticalOrderList = verticalOrderTraversal.verticalOrder(node2);
        System.out.println(verticalOrderList);
    }
}
