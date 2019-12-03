package com.algorithms.leetcode.trees;


import java.util.*;

/**
 *  314. Binary Tree Vertical Order Traversal TODO: INCOMPLETE
 *  https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 */
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer,Map<Integer, List<Integer>>> verticalOrderMap = new TreeMap();
        if(root == null) return null;
        traverseVerticalOrderRecursive(root, verticalOrderMap, 0, 0);
        Iterator<Integer> horizontalIterator = verticalOrderMap.keySet().iterator();
        List<List<Integer>> verticalOrderList = new ArrayList();
//        while(horizontalIterator.hasNext()) {
//            verticalOrderList.add(verticalOrderMap.get(horizontalIterator.next()));
//        }
//        return verticalOrderList;
        return null;
    }

    private void traverseVerticalOrderRecursive(TreeNode root, Map<Integer,Map<Integer, List<Integer>>> verticalOrderMap, int horizontalIndex, int verticleIndex){
        //process left node
        if(root.left != null) traverseVerticalOrderRecursive(root.left, verticalOrderMap, horizontalIndex-1, verticleIndex+1);

        //process root
        Map<Integer, List<Integer>> verticalListMap = verticalOrderMap.get(horizontalIndex);
        if(verticalListMap == null){
            verticalListMap = new TreeMap<Integer, List<Integer>>();
            verticalOrderMap.put(horizontalIndex,verticalListMap);
        }
        List<Integer> horizontalList = verticalListMap.get(verticleIndex);
        if(horizontalList == null){
            horizontalList = new ArrayList<Integer>();
            verticalListMap.put(verticleIndex, horizontalList);
        }
        horizontalList.add(root.val);

        //process right node
        if(root.right != null) traverseVerticalOrderRecursive(root.right, verticalOrderMap, horizontalIndex+1, verticleIndex+1);
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
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
        List<List<Integer>> verticalOrderList = verticalOrderTraversal.verticalOrder(node2);
        System.out.println(verticalOrderList);
    }
}
