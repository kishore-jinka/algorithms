package com.algorithms.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null) return false;
        Boolean[] dp = new Boolean[s.length()+1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            int j=i-1;
            dp[i] = false;
            while(j>=0){
                if(j==0){
                    dp[i] = wordDict.contains(s.substring(0, i));
                }else {
                    dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
                }
                if(dp[i]) break;
                j--;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        WordBreak wb = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = new ArrayList();
        wordDict.add("leet");
        wordDict.add("code");
        boolean foundWordBreak = wb.wordBreak(s,wordDict);
        System.out.println(foundWordBreak);
    }
}
