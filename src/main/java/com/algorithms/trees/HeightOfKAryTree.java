package com.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class HeightOfKAryTree {


    static int find_height(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null || root.children == null) return 0;
        queue.add(root);
        queue.add(null);
        int height = 0;
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode == null){
                if(!queue.isEmpty()){
                    queue.add(null);
                    height++;
                }
            }else{
                for(TreeNode child: currentNode.children){
                    queue.add(child);
                }
            }

        }
        return height;
    }


    static class TreeNode
    {
        Vector<TreeNode> children = new Vector<TreeNode>(0);
        TreeNode()
        {
            children.clear();
        }
    };

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();

        TreeNode node2 = new TreeNode();

        TreeNode node3 = new TreeNode();

        TreeNode node4 = new TreeNode();

        TreeNode node5 = new TreeNode();
        node5.children.add(node4);
        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node5);

        System.out.println(find_height(node1));

    }
}
