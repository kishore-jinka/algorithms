package com.algorithms.trees;


public class AllPathsOfATree {

    static void printAllPaths(TreeNode root){
        String pathString = "";
        printAllPathsRecursive(root, pathString);
    }

    static void printAllPathsRecursive(TreeNode root, String pathString){
        if(root == null) return;
        else{
            if(root.left_ptr == null && root.right_ptr == null){
                System.out.println(pathString + root.val);
                return;
            }
            if(root.left_ptr != null){
                printAllPathsRecursive(root.left_ptr, pathString + root.val + " ");
            }
            if(root.right_ptr != null){
                printAllPathsRecursive(root.right_ptr, pathString + root.val + " ");
            }
        }
    }


    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left_ptr = node4;
        node2.right_ptr = node5;
        node1.left_ptr = node2;
        node1.right_ptr = node3;

        printAllPaths(node1);
    }

    private static class TreeNode{
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
