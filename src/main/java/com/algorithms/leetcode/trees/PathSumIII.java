package com.algorithms.leetcode.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {

    private int numberOfPaths = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        List<Integer> slate = new LinkedList<Integer>();
        pathSumRecursive(root, slate, sum);
        return numberOfPaths;
    }

    private void pathSumRecursive(TreeNode node, List<Integer> slate, int target){
        slate.add(node.val);
        int suffixSum = 0;

        for(int i=slate.size()-1; i>-1; i--){
            suffixSum = suffixSum + slate.get(i);
            if(suffixSum == target) numberOfPaths++;
        }

        if(node.right != null) pathSumRecursive(node.right, slate, target);
        if(node.left != null) pathSumRecursive(node.left, slate, target);
        slate.remove(slate.size()-1);
    }

    public static void main(String[] args){
        //root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8;
        TreeNode root = new TreeNode(10);
        TreeNode level1Node1 = new TreeNode(5);
        TreeNode level1Node2 = new TreeNode(-3);
        TreeNode level2Node1 = new TreeNode(3);
        TreeNode level2Node2 = new TreeNode(2);
        TreeNode level2Node3 = new TreeNode(11);
        TreeNode level3Node1 = new TreeNode(3);
        TreeNode level3Node2 = new TreeNode(-2);
        TreeNode level3Node3 = new TreeNode(1);
        root.left = level1Node1;
        root.right = level1Node2;
        level1Node1.left = level2Node1;
        level1Node1.right = level2Node2;
        level1Node2.right = level2Node3;
        level2Node1.left = level3Node1;
        level2Node1.right = level3Node2;
        level2Node2.right = level3Node3;

        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(root, 8));

    }
}
