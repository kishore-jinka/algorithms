package com.algorithms.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. Minimum Index Sum of Two Lists
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1177/
 */
public class MinimumIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list1.length == 0 || list2.length == 0) return new String[0];
        List<String> resList = new ArrayList();
        boolean haveMoreChoices = false;
        Map<String, Couple> map = new HashMap();
        String minRestaurant = null;
        int minSum = Integer.MAX_VALUE;
        for(int i=0; i<list1.length; i++){
            Couple c = new Couple();
            c.value1 = i+1;
            map.put(list1[i], c);
        }
        for(int i=0; i<list2.length; i++){
            Couple c = map.get(list2[i]);
            if(c == null) c = new Couple();
            c.value2 = i+1;
            map.put(list2[i], c);
        }
        for(String res : map.keySet()){
            Couple c = map.get(res);
            if(c.value1 != 0 && c.value2 != 0){
                resList.add(res);
                if(c.value1 + c.value2 == minSum){
                    haveMoreChoices = true;
                }else if(c.value1 + c.value2 < minSum){
                    minSum = c.value1 + c.value2;
                    minRestaurant = res;
                }
            }
        }
        if(!haveMoreChoices){
            return new String[]{minRestaurant};
        }
        String[] resArray = new String[resList.size()];
        return resList.toArray(resArray);
    }

    private class Couple{
        int value1;
        int value2;
    }

    public static void main(String[] args){
        //String[] resList1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        //String[] resList2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] resList1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] resList2 = {"KNN","KFC","Burger King","Tapioca Express","Shogun"};
        MinimumIndexSum minimumIndexSum = new MinimumIndexSum();
        String[] topChoice = minimumIndexSum.findRestaurant(resList1, resList2);
        for(String s : topChoice){
            System.out.println(s);
        }
    }
}
