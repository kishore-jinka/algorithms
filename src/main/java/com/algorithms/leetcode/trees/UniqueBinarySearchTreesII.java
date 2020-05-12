package com.algorithms.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2384/
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }
        return generateTreesRecursive(1, n);
    }

    private List<TreeNode> generateTreesRecursive(int start, int end){
        List<TreeNode> list = new ArrayList();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i=start; i<=end; i++) {
            List<TreeNode> leftSubTreeList = generateTreesRecursive(start, i - 1);
            List<TreeNode> rightSubTreeList = generateTreesRecursive(i + 1, end);
            for(TreeNode leftSubTree : leftSubTreeList){
                for(TreeNode rightSubTree : rightSubTreeList){
                    TreeNode rootNode = new TreeNode(i);
                    rootNode.left = leftSubTree;
                    rootNode.right = rightSubTree;
                    list.add(rootNode);
                }
            }
        }
        return list;
    }
}
