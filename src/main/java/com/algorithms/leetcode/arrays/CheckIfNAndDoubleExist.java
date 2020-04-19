package com.algorithms.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1346. Check If N and Its Double Exist
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 * https://leetcode.com/explore/featured/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
 */
public class CheckIfNAndDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for(int i : arr){
            if(map.get(i) != null){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }
        for(int i : arr){
            if(i==0 && map.get(i) != null && map.get(i) == 2){
                return true;
            }else if(i!=0 && map.get(i*2) != null){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] array = {-2,0,10,-19,4,6,-8};
        CheckIfNAndDoubleExist checkIfNAndDoubleExist = new CheckIfNAndDoubleExist();
        System.out.println(checkIfNAndDoubleExist.checkIfExist(array));
    }
}
