package com.algorithms.leetcode.trees;

import java.util.*;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * TODO: INCOMPLETE
 */
public class VeritcalOrderTraversal2 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        if(root == null) return finalList;
        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        QueueNode rootQNode = new QueueNode(root, 0);
        queue.add(rootQNode);
        List<SortedMap<Integer, List<Integer>>> listY = new ArrayList();
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            SortedMap<Integer, List<Integer>> sortedXMap = new TreeMap<Integer, List<Integer>>();
            for(int i=0; i<numberOfNodes; i++){
                QueueNode qNode = queue.poll();
                if(sortedXMap.get(qNode.x) == null) sortedXMap.put(qNode.x, new ArrayList<Integer>());
                sortedXMap.get(qNode.x).add(qNode.node.val);
                if(qNode.node.left != null) queue.add(new QueueNode(qNode.node.left, qNode.x - 1));
                if(qNode.node.right != null) queue.add(new QueueNode(qNode.node.right, qNode.x + 1));
            }
            listY.add(sortedXMap);
        }

        for(int i=0; i<listY.size(); i++){
            SortedMap<Integer, List<Integer>> sortedXMap = listY.get(i);
            List<Integer> list = new ArrayList();
            Iterator<Integer> itr = sortedXMap.keySet().iterator();
            while(itr.hasNext()){
                List<Integer> listX = sortedXMap.get(itr.next());
                Collections.sort(listX);
                list.addAll(list);
            }
            finalList.add(list);
        }
        return finalList;
    }

    private class QueueNode{
        TreeNode node;
        int x;
        QueueNode(TreeNode node, int x){
            this.node = node;
            this.x = x;
        }
        public TreeNode getNode(){
            return node;
        }
        public int getX(){
            return x;
        }
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
        VeritcalOrderTraversal2 verticalOrderTraversal2 = new VeritcalOrderTraversal2();
        List<List<Integer>> verticalOrderList2 = verticalOrderTraversal2.verticalTraversal(node2);
        System.out.println(verticalOrderList2);
    }

}
