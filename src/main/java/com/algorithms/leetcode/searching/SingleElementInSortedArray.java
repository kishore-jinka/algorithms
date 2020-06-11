package com.algorithms.leetcode.searching;

/**
 * 540. Single Element in a Sorted Array
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
 * This is similar to 136. Single Number https://leetcode.com/problems/single-number/
 * TODO: INCOMPLETE
 */
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1] && nums[mid-1] != nums[mid+1]) {
                return nums[mid];
            } else if((mid%2 == 0 && nums[mid] == nums[mid+1])
                    ||(mid%2 == 1 && nums[mid-1] == nums[mid])){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array = {1,1,2};
        SingleElementInSortedArray sn = new SingleElementInSortedArray();
        System.out.println(sn.singleNonDuplicate(array));
    }
}
