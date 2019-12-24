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
        System.out.println(startAndEndMap);
        List<String> finalList = new ArrayList<String>();
        if(dp[s.length()]){
            constructStringList(s, s.length(), "", startAndEndMap, finalList);
        }
        return finalList;
    }

    private void insertInMap(Integer start, Integer end, Map<Integer,List<Integer>> startAndEndMap){
        List<Integer> list = startAndEndMap.get(end);
        if(list == null){
            startAndEndMap.put(end, new ArrayList<Integer>());
            list = startAndEndMap.get(end);
        }
        list.add(start);
    }

   private void constructStringList(String input, Integer endIndex, String intermediate, Map<Integer,List<Integer>> startAndEndMap, List<String> finalList){
        if(endIndex == 0){
            finalList.add(intermediate.trim());
            return;
        }else{
            List<Integer> startIndices = startAndEndMap.get(endIndex);
            for(Integer startIndex : startIndices){
                constructStringList(input, startIndex, input.substring(startIndex, endIndex) + " " + intermediate, startAndEndMap, finalList);
            }
        }
   }

    public static void main(String[] args){
        WordBreakII wb2 = new WordBreakII();
        String s = "catsanddog";
        List<String> wordDict = new ArrayList();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> wb2List = wb2.wordBreak(s,wordDict);
        System.out.println(wb2List);
    }
}
