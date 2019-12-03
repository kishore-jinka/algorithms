package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Name: LeetCode 116. Populating Next Right Pointers in Each Node
 * Description:
 * Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Label: LeetCode Learn Binary Tree  problem
 * Author: Kishore Jinka
 */
public class PopulateNextRightPointersInEachNode {

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        if(root == null) return root;
        queue.add(root);
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            Node previousNode = queue.peek();
            List<Integer> internalList = new ArrayList<Integer>();
            for(int i=0; i<numberOfNodes; i++){
                Node node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(i>0) {
                    previousNode.next = node; //link
                    previousNode = node; //reset
                }
            }
        }
        return root;
    }


    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
