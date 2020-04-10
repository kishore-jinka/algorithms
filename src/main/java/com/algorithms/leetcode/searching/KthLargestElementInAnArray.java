package com.algorithms.leetcode.searching;

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * QuickSelect algorithm to find n-k smallest element
 * TODO: INCOMPLETE
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, nums.length - k , 0, nums.length-1);
    }

    private int findKthSmallest(int[] nums, int k, int start, int end){
        if(start == end) return nums[k-1];
        int orangeIndex = findLomutosParitionIndex(nums, start, end);
        if(orangeIndex < k-1) return findKthSmallest(nums, k, orangeIndex+1, end);
        if(orangeIndex > k-1) return findKthSmallest(nums, k, start, orangeIndex-1);
        return nums[k-1];
    }

    private int findLomutosParitionIndex(int[] nums, int start, int end){
        int orangeIndex = -1;
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
        //int[] a = {3,1,2,4};
        //int[] a = {3,2,1,5,6,4};
        //int[] a = {3,2,3,1,2,4,5,5,6};
        //int k = 2;
        //int[] a = {7,6,5,4,3,2,1};
        //2
        int[] a = {64, 25, 12, 22, 23};
        KthLargestElementInAnArray myClass = new KthLargestElementInAnArray();
        System.out.println(myClass.findKthSmallest(a, 4, 0, a.length - 1));
//        System.out.println(myClass.findLomutosParitionIndex(a,0, a.length - 1));
//        for(int i : a){
//            System.out.println(i);
//        }
    }
}

//System.out.println(myClass.findKthLargest(a, k));