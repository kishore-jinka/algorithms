package com.algorithms.leetcode.arrays;

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 * https://leetcode.com/explore/featured/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        while(i<m+n && j<n){
            if(nums2[j] <=nums1[i]){
                int tmp = nums1[i];
                nums1[i] = nums2[j];
                for(int k=i+1; k<nums1.length; k++){
                    int newTmp = nums1[k];
                    nums1[k] = tmp;
                    tmp = newTmp;
                }
                j++;
            }
            i++;
        }
        if(j<nums2.length){
            i = nums1.length - nums2.length + j;
            while(i<nums1.length && j<nums2.length){
                nums1[i] = nums2[j];
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args){
        //int[] nums1 = {1,2,3,0,0,0};
        //int[] nums2 = {2,5,6};
        //int[] nums1 = {2,0};
        //int[] nums2 = {1};
        int[] nums1 = {-1,0,0,3,3,3,0,0,0};
        int[] nums2 = {1,2,2};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, 6, nums2, 3);
        for(int i:nums1){
            System.out.println(i);
        }
    }

}
