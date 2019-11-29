package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N-ary Tree Level Order Traversal
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            List<Integer> internalList = new ArrayList<Integer>();
            for(int i=0; i<numberOfNodes; i++){
                Node node = queue.poll();
                internalList.add(node.val);
                for(Node childNode : node.children){
                    queue.add(childNode);
                }
            }
            list.add(internalList);
        }
        return list;
    }

}
