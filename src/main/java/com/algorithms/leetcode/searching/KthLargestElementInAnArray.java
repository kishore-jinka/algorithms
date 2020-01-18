package com.algorithms.leetcode.searching;

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * QuickSelect algorithm to find (n-k+1) smallest element
 * TODO: INCOMPLETE
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return findMthSmallestQuickSelect(nums, nums.length - k + 1, 0, nums.length-1);
    }

    private int findMthSmallestQuickSelect(int[] nums, int m, int start, int end){
        if(start >= end){
            return nums[m-1];
        }
        int pivotIndex = lomutosParition(nums, start, end);
        if(pivotIndex == m-1){
            return nums[m-1];
        }else if(pivotIndex < m-1){
            return findMthSmallestQuickSelect(nums, m, pivotIndex+1, end);
        }else{
            return findMthSmallestQuickSelect(nums, m, start, pivotIndex-1);
        }
    }

    private static int lomutosParition(int[] nums, int start, int end){
        int frontEndIterator = start+1;
        int backEndIterator = end;
        int pivotIndex = start;
        while(frontEndIterator<backEndIterator){
            if(nums[frontEndIterator]>nums[pivotIndex] && nums[backEndIterator]<=nums[pivotIndex]){
                int tmp = nums[frontEndIterator];
                nums[frontEndIterator] = nums[backEndIterator];
                nums[backEndIterator] = tmp;
                frontEndIterator++;
                backEndIterator--;
            }else if(nums[frontEndIterator]>nums[pivotIndex] && nums[backEndIterator]>nums[pivotIndex]){
                backEndIterator--;
            }else if(nums[frontEndIterator]<=nums[pivotIndex] && nums[backEndIterator]<=nums[pivotIndex]){
                frontEndIterator++;
            }else if(nums[frontEndIterator]<=nums[pivotIndex] && nums[backEndIterator]>nums[pivotIndex]){
                frontEndIterator++;
                backEndIterator--;
            }
        }
        if(nums[backEndIterator] < nums[pivotIndex]){
            int tmp = nums[backEndIterator];
            nums[backEndIterator] = nums[pivotIndex];
            nums[pivotIndex] = tmp;
            pivotIndex = backEndIterator;
        }
        for(int a : nums){
            System.out.print(a);
        }
        System.out.println();
        System.out.println("frontEndIterator: " + frontEndIterator);
        System.out.println("backEndIterator: " + backEndIterator);
        System.out.println("pivotIndex: " + pivotIndex);
        //if(frontEndIterator==backEndIterator) return backEndIterator - 1;
        return pivotIndex;
    }

    public static void main(String[] args){
        //int[] a = {3,1,2,4};
        int[] a = {3,2,1,5,6,4};
        //int[] a = {3,2,3,1,2,4,5,5,6};
        //int k = 2;
        //int[] a = {7,6,5,4,3,2,1};
        //2
        KthLargestElementInAnArray myClass = new KthLargestElementInAnArray();
        //System.out.println(myClass.findKthLargest(a, k));
        System.out.println(lomutosParition(a,0, a.length - 1));
    }
}


//for(int a : nums){
//    System.out.print(a);
//}
//System.out.println();

