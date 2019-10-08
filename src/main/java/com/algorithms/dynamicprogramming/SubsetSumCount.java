package com.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class SubsetSumCount {

    private static int recurssiveCountSubsets(int[] intArray, int total, int endIndex){
        int result = 0;
        if(total == 0) result = 1;
        else if(total < 0) result = 0;
        else if(endIndex < 0) result = 0;
        else if(total < intArray[endIndex]) result = recurssiveCountSubsets(intArray, total, endIndex -1);
        else result = recurssiveCountSubsets(intArray, total - intArray[endIndex], endIndex -1)
                    + recurssiveCountSubsets(intArray, total, endIndex -1);
        return result;
    }

    private static int dynamicCountSubsets(int[] intArray, int total, int endIndex, Map<String, Integer> map){
        if(map.get(total+":"+endIndex) != null) return map.get(total+":"+endIndex);
        int result = 0;
        if(total == 0) result = 1;
        else if(total < 0) result = 0;
        else if(endIndex < 0) result = 0;
        else if(total < intArray[endIndex]) result = dynamicCountSubsets(intArray, total, endIndex -1, map);
        else result = dynamicCountSubsets(intArray, total - intArray[endIndex], endIndex -1, map)
                    + dynamicCountSubsets(intArray, total, endIndex -1, map);
        map.put(total + ":" + endIndex, result);
        return result;
    }

    public static void main(String[] args){
        int[] intArray = new int[]{2, 4, 6, 10};
        int total = 16;
        //System.out.println(countRecurssiveSubsets(intArray, total, intArray.length - 1));
        Map<String, Integer> map = new HashMap<String, Integer>();
        System.out.println(dynamicCountSubsets(intArray, total, intArray.length - 1, map));
    }
}
