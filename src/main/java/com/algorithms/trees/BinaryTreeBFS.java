package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBFS {

    public List<Integer> traverseLevelOrder(TreeNode rootNode){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(rootNode == null) return null;
        queue.add(rootNode);
        List<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return list;
    }

    public List<List<Integer>> traverseLevelOrder2(TreeNode rootNode){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(rootNode == null) return null;
        queue.add(rootNode);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            List<Integer> internalList = new ArrayList<Integer>();
            for(int i=0; i<numberOfNodes; i++){
                TreeNode node = queue.poll();
                internalList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(internalList);
        }
        return list;
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
        BinaryTreeBFS btBFS = new BinaryTreeBFS();
        List<Integer> levelOrderedList = btBFS.traverseLevelOrder(node2);
        //System.out.println(levelOrderedList);
        List<List<Integer>> levelOrderedList2 = btBFS.traverseLevelOrder2(node2);
        System.out.println(levelOrderedList2);
    }
}
