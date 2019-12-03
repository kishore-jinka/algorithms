package com.algorithms.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 993. Cousins in Binary Tree
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                boolean isLeftParent = false;
                boolean isRightParent = false;
                if(node.left != null){
                    queue.add(node.left);
                    if(node.left.val == x){
                        xFound = true;
                        isLeftParent = true;
                    }else if(node.left.val == y){
                        yFound = true;
                        isLeftParent = true;
                    }
                }
                if(node.right != null){
                    queue.add(node.right);
                    if(node.right.val == x){
                        xFound = true;
                        isRightParent = true;
                    }else if(node.right.val == y){
                        yFound = true;
                        isRightParent = true;
                    }
                }
                if(xFound && yFound){
                    if(isLeftParent && isRightParent){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
