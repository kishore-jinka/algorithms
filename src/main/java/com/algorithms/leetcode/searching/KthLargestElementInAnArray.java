package com.algorithms.leetcode.searching;

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * QuickSelect algorithm to find n-k+1 smallest element
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if(k<1 || k>nums.length) return Integer.MIN_VALUE;
        return findKthSmallest(nums, nums.length - k + 1 , 0, nums.length-1);
    }

    //Quick select algorithm - my most favorite *****************
    private int findKthSmallest(int[] nums, int k, int start, int end){
        if(start == end) return nums[k-1];
        int orangeIndex = findLomutosPartitionIndex(nums, start, end);
        if(orangeIndex < k-1) return findKthSmallest(nums, k, orangeIndex+1, end);
        if(orangeIndex > k-1) return findKthSmallest(nums, k, start, orangeIndex-1);
        return nums[k-1];
    }

    private int findLomutosPartitionIndex(int[] nums, int start, int end){
        int orangeIndex = start-1;
        int pivot = nums[end];
        for(int greenIndex = start; greenIndex <= end; greenIndex ++){
            if(nums[greenIndex] <= pivot){
                orangeIndex ++;
                int temp = nums[greenIndex];
                nums[greenIndex] = nums[orangeIndex];
                nums[orangeIndex] = temp;
            }
        }
        return orangeIndex;
    }

    public static void main(String[] args){
        int[] a = {64, 25, 12, 22, 23};
        KthLargestElementInAnArray myClass = new KthLargestElementInAnArray();
        //System.out.println(myClass.findKthSmallest(a, 2, 0, a.length - 1));
        System.out.println(myClass.findKthLargest(a, 4));
    }
}
