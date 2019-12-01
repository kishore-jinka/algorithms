package com.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Name: LeetCode 559. Maximum Depth of N-ary Tree
 * Description: Given a n-ary tree, find its maximum depth.
 *              The maximum depth is the number of nodes along the
 *              longest path from the root node down to the farthest leaf node.
 * Link: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 * Label: IK Recommended LeetCode
 * Author: Kishore Jinka
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
