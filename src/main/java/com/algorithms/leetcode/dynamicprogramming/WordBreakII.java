package com.algorithms.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null) return null;
        Boolean[] dp = new Boolean[s.length()];
        dp[0] = wordDict.contains(s.substring(0,1));
        for(int i=1; i<s.length(); i++){
            int j=i;
            dp[i] = false;
            while(j>=0){
                if(j==0){
                    dp[i] = wordDict.contains(s.substring(0, i + 1));
                }else {
                    dp[i] = dp[j - 1] && wordDict.contains(s.substring(j, i + 1));
                }
                if(dp[i]) break;
                j--;
            }
        }
        //return dp[s.length()-1];
        return null;
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


/*
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
 */
