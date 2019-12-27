package com.algorithms.leetcode.dynamicprogramming;


/**
 * 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i=0; i<=s1.length(); i++){
            for(int j=0; j<=s2.length(); j++){
                if(i==0 && j==0) continue;
                boolean fromS1 = false;
                boolean fromS2 = false;
                if(i==0 && j>0){
                    fromS2 = dp[0][j-1] && s2.charAt(j-1)==s3.charAt(j-1);
                }
                if(i>0 && j==0){
                    fromS1 = dp[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
                }
                if(i>0 && j>0){
                    fromS1 = dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1);
                    fromS2 = dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1);
                }
                dp[i][j] = fromS1 || fromS2;
            }
        }
        return dp[s1.length()][s2.length()];
    }


    public static void main(String[] args){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave(s1, s2, s3));
    }
}
