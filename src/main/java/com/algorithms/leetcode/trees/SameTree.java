package com.algorithms.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<TreeNode>();
        Queue<TreeNode> queueQ = new LinkedList<TreeNode>();
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        queueP.add(p);
        queueQ.add(q);
        while(!queueP.isEmpty() && !queueQ.isEmpty()){
            int numberOfNodes = queueP.size();
            for(int i=0; i<numberOfNodes; i++){
                TreeNode nodeP = queueP.poll();
                TreeNode nodeQ = queueQ.poll();
                if(nodeP.val != nodeQ.val) return false;
                boolean leftPAdded = false;
                boolean rightPAdded = false;
                boolean leftQAdded = false;
                boolean rightQAdded = false;
                if (nodeP.left != null){
                    queueP.add(nodeP.left);
                    leftPAdded = true;
                }
                if (nodeP.right != null){
                    queueP.add(nodeP.right);
                    rightPAdded = true;
                }
                if (nodeQ.left != null){
                    queueQ.add(nodeQ.left);
                    leftQAdded = true;
                }
                if (nodeQ.right != null){
                    queueQ.add(nodeQ.right);
                    rightQAdded = true;
                }
                if(leftPAdded != leftQAdded || rightPAdded != rightQAdded) return false;
            }
        }
        return true;
    }
}
