package com.algorithms.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 559. Maximum Depth of N-ary Tree
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaxDepthOfNaryTree {

    public int maxDepth(Node root){
        int maxDepth = 0;
        Queue<Node> queue = new LinkedList<Node>();
        if(root == null) return maxDepth;
        queue.add(root);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            for(int i=0; i<numberOfNodes; i++){
                Node node = queue.poll();
                for(Node childNode : node.children){
                    queue.add(childNode);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

}
