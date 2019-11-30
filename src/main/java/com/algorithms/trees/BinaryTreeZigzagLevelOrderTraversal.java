package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        queue.add(root);
        boolean nodesInReverse = false;
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            LinkedList<Integer> internalList = new LinkedList<Integer>();
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                if(nodesInReverse){
                    internalList.addFirst(node.val);
                }else{
                    internalList.add(node.val);
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(internalList);
            if(!nodesInReverse){
                nodesInReverse = true;
            }else{
                nodesInReverse = false;
            }
        }
        return list;
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
        BinaryTreeZigzagLevelOrderTraversal btZigzag = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> zigzagLevelOrder = btZigzag.zigzagLevelOrder(node2);
        System.out.println(zigzagLevelOrder);
    }
}
