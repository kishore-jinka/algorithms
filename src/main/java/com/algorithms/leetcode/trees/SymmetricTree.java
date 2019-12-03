package com.algorithms.leetcode.trees;

import java.util.*;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }else if(root.left == null & root.right == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode minNode = new TreeNode(Integer.MIN_VALUE);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            boolean nextRowIsNull = true;
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                if(node.left == null){
                    queue.add(minNode);
                }else{
                    queue.add(node.left);
                    nextRowIsNull = false;
                }
                if(node.right == null){
                    queue.add(minNode);
                }else{
                    queue.add(node.right);
                    nextRowIsNull = false;
                }
            }
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.addAll(queue);
            for(int i=0; i<list.size()/2; i++){
                if(list.get(i).val != list.get(list.size() - i - 1).val) return false;
            }
            if(nextRowIsNull) break;
        }
        return true;
    }

    public static void main(String[] args){
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node2_2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node3_1 = new TreeNode(3);
        TreeNode node3_2 = new TreeNode(3);
        node1.left = node2_1;
        node1.right = node2_2;
        node2_1.left = node3_1;
        node2_1.right = node4_1;
        node2_2.left = node4_2;
        //node2_2.right = node3_2;
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(node1));
    }
}