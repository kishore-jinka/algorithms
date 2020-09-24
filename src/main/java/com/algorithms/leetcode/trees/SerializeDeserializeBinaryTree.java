package com.algorithms.leetcode.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if(root == null) return null;
        StringBuffer stringBuffer = new StringBuffer();
        dfsSerialize(root, stringBuffer);
        stringBuffer.delete(stringBuffer.length()-1, stringBuffer.length());
        return stringBuffer.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuffer stringBuffer){
        if(node != null) stringBuffer.append(node.val + ",");
        if(node.left != null){
            dfsSerialize(node.left, stringBuffer);
        }else{
            stringBuffer.append("null,");
        }
        if(node.right != null){
            dfsSerialize(node.right, stringBuffer);
        }else{
            stringBuffer.append("null,");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
        Queue<String> queue = new LinkedList<String>();
        while(stringTokenizer.hasMoreTokens()){
            queue.add(stringTokenizer.nextToken());
        }
        return dfsDeserialize(queue);
    }

    private TreeNode dfsDeserialize(Queue<String> queue){
        if(queue.isEmpty()) return null;
        String value = queue.poll();
        if(value.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = dfsDeserialize(queue);
        root.right = dfsDeserialize(queue);
        return root;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        SerializeDeserializeBinaryTree sdBT = new SerializeDeserializeBinaryTree();
        String serialized = sdBT.serialize(node1);
        System.out.println(serialized);
        TreeNode root = sdBT.deserialize(serialized);
        BinaryTreeInOrderTraversal binaryTreeInOrderTraversal = new BinaryTreeInOrderTraversal();
        List<Integer> inorderList = binaryTreeInOrderTraversal.inorderTraversal(root);
        BinaryTreePreOrderTraversal binaryTreePreOrderTraversal = new BinaryTreePreOrderTraversal();
        List<Integer> preorderList = binaryTreePreOrderTraversal.preorderTraversal(root);
        System.out.println("Inorder List: " + inorderList.toString());
        System.out.println("Preorder List: " + preorderList.toString());
    }

    //Serialize using BFS
    public String serializeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if(root == null) return null;
        StringBuffer stringBuffer = new StringBuffer();
        queue.add(root);
        stringBuffer.append(root.val + ",");
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
                stringBuffer.append(node.left.val);
            } else {
                stringBuffer.append("null");
            }
            stringBuffer.append(",");
            if(node.right != null){
                queue.add(node.right);
                stringBuffer.append(node.right.val);
            } else {
                stringBuffer.append("null");
            }
            stringBuffer.append(",");
        }
        stringBuffer.delete(stringBuffer.length()-1, stringBuffer.length());
        return stringBuffer.toString();
    }

}
