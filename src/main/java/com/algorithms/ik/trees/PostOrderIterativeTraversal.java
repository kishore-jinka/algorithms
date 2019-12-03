package com.algorithms.ik.trees;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterativeTraversal {

    static int[] postorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        List<Integer> postOrderList = new ArrayList<Integer>();
        while(current != null || !stack.empty()){
            if(current != null){
                stack.push(current);
                current = current.left_ptr;
            }else{
                TreeNode temp = stack.peek().right_ptr;
                if(temp == null){
                    temp = stack.pop();
                    postOrderList.add(temp.val);
                    while(!stack.empty() && temp.val == stack.peek().right_ptr.val){
                        temp = stack.pop();
                        postOrderList.add(temp.val);
                    }
                }else{
                    current = temp;
                }
            }

        }

        int[] postOrderIntegers = new int[postOrderList.size()];
        for(int i=0; i<postOrderList.size(); i++)
            postOrderIntegers[i] = postOrderList.get(i);
        return postOrderIntegers;
    }

    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode();
        node1.val = 1;
        TreeNode node2 = new TreeNode();
        node2.val = 2;
        TreeNode node3 = new TreeNode();
        node3.val = 3;
        TreeNode node4 = new TreeNode();
        node4.val = 4;
        TreeNode node5 = new TreeNode();
        node5.val = 5;
        TreeNode node6 = new TreeNode();
        node6.val = 6;
        TreeNode node7 = new TreeNode();
        node7.val = 7;
        node2.left_ptr = node4;
        node2.right_ptr = node5;
        node3.left_ptr = node6;
        node3.right_ptr = node7;
        node1.left_ptr = node2;
        node1.right_ptr = node3;

        int[] postOrder = postorderTraversal(node1);
        for(int i: postOrder){
            System.out.println(i);
        }
    }


}
