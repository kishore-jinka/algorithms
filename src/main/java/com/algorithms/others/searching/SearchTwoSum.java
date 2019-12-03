package com.algorithms.others.searching;

/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?
 */

import java.util.HashSet;
import java.util.Set;

public class SearchTwoSum {
/*
    def two_sum(lst, k):
    seen = set()
    for num in lst:
            if k - num in seen:
            return True
        seen.add(num)
            return False
*/
    private static boolean searchTwoSum(Integer[] array, Integer sum){
        Set<Integer> integerSet = new HashSet<Integer>();
        for(Integer i : array){
            if(integerSet.contains(i)) {
                System.out.println(i + " + " + (sum-i) + " = " + sum);
                return true;
            }
            integerSet.add(sum-i);
        }
        return false;
    }

    public static void main(String[] args){
        Integer[] array = {10, 15, 3, 7};
        Integer sum = 17;
        System.out.println(searchTwoSum(array, sum));
    }
}
