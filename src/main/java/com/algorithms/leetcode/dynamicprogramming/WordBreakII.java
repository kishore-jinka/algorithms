package com.algorithms.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 140. Word Break II
 * https://leetcode.com/problems/word-break-ii/
 * Really Hard
 */
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null) return null;
        Map<Integer,List<Integer>> startAndEndMap = new HashMap();
        Boolean[] dp = new Boolean[s.length()+1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            int j=i-1;
            dp[i] = false;
            while(j>=0){
                Boolean dpLocal = false;
                if(j==0){
                    dpLocal = wordDict.contains(s.substring(0, i));
                }else {
                    dpLocal = dp[j] && wordDict.contains(s.substring(j, i));
                }
                if(dpLocal){
                    dp[i] = dpLocal;
                    insertInMap(j,i,startAndEndMap);
                }
                j--;
            }
        }
        List<String> finalList = new ArrayList<String>();
        if(dp[s.length()]){
            constructStringList(s, 0, "", startAndEndMap, finalList);
        }
        return finalList;
    }

    private void insertInMap(Integer start, Integer end, Map<Integer,List<Integer>> startAndEndMap){
        List<Integer> list = startAndEndMap.get(start);
        if(list == null){
            startAndEndMap.put(start, new ArrayList<Integer>());
            list = startAndEndMap.get(start);
        }
        list.add(end);
    }

   private void constructStringList(String input, Integer startIndex, String intermediate, Map<Integer,List<Integer>> startAndEndMap, List<String> finalList){
        if(startAndEndMap.get(startIndex) == null){
            if(startIndex == input.length()) {
                finalList.add(intermediate.trim());
            }
            return;
        }else{
            List<Integer> endIndices = startAndEndMap.get(startIndex);
            for(Integer endIndex : endIndices){
                constructStringList(input, endIndex, intermediate + " " + input.substring(startIndex, endIndex), startAndEndMap, finalList);
            }
        }
   }

    public static void main(String[] args){
        WordBreakII wb2 = new WordBreakII();
        String s = "abcd";
        List<String> wordDict = new ArrayList();
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");
        List<String> wb2List = wb2.wordBreak(s,wordDict);
        System.out.println(wb2List);
    }
}
