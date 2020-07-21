package com.algorithms.leetcode.dynamicprogramming;

/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        if(chars[0] != '0') dp[1] = 1;
        for(int i=2; i<=chars.length; i++){
            if(chars[i-1] != '0') dp[i] = dp[i-1] ;
            if(chars[i-2] == '1'
                    || (chars[i-2] == '2'
                    && (chars[i-1] == '0'
                        || chars[i-1] == '1'
                        || chars[i-1] == '2'
                        || chars[i-1] == '3'
                        || chars[i-1] == '4'
                        || chars[i-1] == '5'
                        || chars[i-1] == '6'))){
                dp[i] = dp[i] + dp[i-2];
            }
        }
        return dp[chars.length];
    }

    public static void main(String[] args){
        String s = "226";
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings(s));
    }
}
