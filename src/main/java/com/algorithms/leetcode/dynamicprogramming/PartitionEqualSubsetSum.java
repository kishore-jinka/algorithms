package com.algorithms.leetcode.dynamicprogramming;

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum = sum + i;
        }
        //System.out.println(sum);
        if(sum%2 != 0) return false;
        int partitionSum = sum/2;
        boolean[][] dp = new boolean[nums.length][partitionSum];
        for(int row = 0; row < nums.length; row++){
            for(int column = 0; column < partitionSum; column++){
                boolean numEqualsPartitionSum = nums[row] == column + 1;
                if(row == 0) {
                    dp[row][column] = numEqualsPartitionSum;
                }else if(column == 0){
                    dp[row][column] = numEqualsPartitionSum || dp[row-1][column];
                }else{
                    boolean numEqualsLowerPartitionSum = column >= nums[row] && dp[row-1][column-nums[row]];
                    dp[row][column] = numEqualsPartitionSum || dp[row-1][column] || numEqualsLowerPartitionSum;
                }
                //System.out.print(dp[row][column] + ",");
            }
            //System.out.println();
        }
        return dp[nums.length - 1][partitionSum - 1];
    }

    public static void main(String[] args){
        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(nums1));
        System.out.println(partitionEqualSubsetSum.canPartition(nums2));
    }
}

/*
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].


Example 2:

Input: [1, 2, 3, 5]

Output: false
 */