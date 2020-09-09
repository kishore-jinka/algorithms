package com.algorithms.leetcode.trees;

/**
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
public class ConvertBstToDll {
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node dummyPredecessor = new Node(-1);
        Node tail = dfs(root, dummyPredecessor);
        Node head = dummyPredecessor.right;
        tail.right = head;
        head.left = tail;
        return head;
    }

    private Node dfs(Node node, Node predecessor){
        if(node.left == null && node.right == null){
            predecessor.right = node;
            node.left = predecessor;
            return node;
        }
        if(node.left != null){
            predecessor = dfs(node.left, predecessor);
        }
        predecessor.right = node;
        node.left = predecessor;
        predecessor = node;
        if(node.right != null){
            predecessor = dfs(node.right, node);
        }
        return predecessor;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
