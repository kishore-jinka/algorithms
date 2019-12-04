package com.algorithms.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. Add One Row to Tree
 * https://leetcode.com/problems/add-one-row-to-tree/
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return root;
        if(d==1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                if(level == d-1){
                    TreeNode newLeftNode = new TreeNode(v);
                    newLeftNode.left = node.left;
                    node.left = newLeftNode;
                    TreeNode newRightNode = new TreeNode(v);
                    newRightNode.right = node.right;
                    node.right = newRightNode;
                }else {
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            if(level == d-1) return root;
            level++;
        }
        return root;
    }


}
