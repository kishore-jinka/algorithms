package com.algorithms.leetcode.arrays;

import java.util.*;

/**
 * 414. Third Maximum Number
 * https://leetcode.com/problems/third-maximum-number/
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        SortedSet<Integer> sortedSet = new TreeSet();
        for(int i : nums){
            sortedSet.add(i);
        }
        if(sortedSet.size() < 3){
            return sortedSet.last();
        }
        sortedSet.remove(sortedSet.last());
        sortedSet.remove(sortedSet.last());
        return sortedSet.last();
    }

    public static void main(String[] args){
        int[] a = {64, 25, 12, 22, 23};
        //int[] a = {1,1,2};
        ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
        System.out.println(thirdMaximumNumber.thirdMax(a));
    }
}
