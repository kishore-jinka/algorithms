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
        return dp[s.length()-1];
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
