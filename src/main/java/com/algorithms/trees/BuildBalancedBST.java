package com.algorithms.trees;

public class BuildBalancedBST {

    static TreeNode build_balanced_bst(int[] a){
        if(a.length == 0) return null;
        if(a.length == 1) return new TreeNode(a[0]);
        return getBST(a, 0, a.length-1);
    }

    static TreeNode getBST(int arr[], int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left_ptr = getBST(arr, start, mid - 1);
        node.right_ptr = getBST(arr, mid + 1, end);
        return node;
    }

    //int a[] = {8, 10, 12, 15, 16, 20, 25],

    static class TreeNode
    {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val)
        {
            val = _val;
            left_ptr = null;
            right_ptr = null;
        }
    };

    public static void main(String[] args) {
        int a[] = {8, 10, 12, 15, 16, 20, 25};
        //System.out.println(kth_smallest_element(node1));
        System.out.println(7/2);
    }
}
