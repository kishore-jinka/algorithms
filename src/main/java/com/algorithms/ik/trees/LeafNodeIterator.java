package com.algorithms.ik.trees;


import java.util.Iterator;
import java.util.Stack;

/**
 * LeafNodeIterator: Can be used to compare leaves of two different rees
 */
public class LeafNodeIterator implements Iterator<TreeNode>{

    private TreeNode currentLeafNode = null;
    private Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();

    public LeafNodeIterator(TreeNode rootNode){
        treeNodeStack.add(rootNode);
    }

    public boolean hasNext() {
        if(currentLeafNode != null) return true;
        while(!treeNodeStack.isEmpty()){
            TreeNode treeNode = treeNodeStack.pop();
            if(treeNode.left == null && treeNode.right == null){
                currentLeafNode = treeNode;
                return true;
            }
            if(treeNode.right != null) treeNodeStack.push(treeNode);
            if(treeNode.left != null) treeNodeStack.push(treeNode);
        }
        return false;
    }

    public TreeNode next() {
        if(currentLeafNode == null) throw new IllegalStateException();
        TreeNode treeNode = currentLeafNode;
        currentLeafNode = null;
        return treeNode;
    }

    public void remove() {

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
        LeafNodeIterator leafNodeIterator = new LeafNodeIterator(node2);
        while(leafNodeIterator.hasNext()){
            System.out.println("leaf node -> " + leafNodeIterator.next().val);
        }
    }
}


