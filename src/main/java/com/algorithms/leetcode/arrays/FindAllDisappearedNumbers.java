package com.algorithms.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3270/
 */
public class FindAllDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappeared = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            nums[(nums[i]-1)%(nums.length+1)] = nums[(nums[i]-1)%(nums.length+1)] + nums.length + 1;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] / (nums.length + 1) == 0){
                disappeared.add(i+1);
            }
        }
        return disappeared;
    }

    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        FindAllDisappearedNumbers findAllDisappearedNumbers = new FindAllDisappearedNumbers();
        System.out.println(findAllDisappearedNumbers.findDisappearedNumbers(nums));
    }
}
