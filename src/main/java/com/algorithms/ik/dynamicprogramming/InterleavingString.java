package com.algorithms.ik.dynamicprogramming;

public class InterleavingString {

    public static boolean doStringsInterleave(String a, String b, String i){
        if(a.length() + b.length() != i.length()) return false;
        boolean[][] dp = new boolean[a.length()+1][b.length()+1];
        dp[0][0] = true;
        for(int k=0; k<=a.length(); k++){
            for(int j=0; j<=b.length(); j++){
                if(k==0 && j==0) continue;
                boolean fromS1 = false;
                boolean fromS2 = false;
                if(k==0 && j>0){
                    fromS2 = dp[0][j-1] && b.charAt(j-1)==i.charAt(j-1);
                }
                if(k>0 && j==0){
                    fromS1 = dp[k-1][0] && a.charAt(k-1)==i.charAt(k-1);
                }
                if(k>0 && j>0){
                    fromS1 = dp[k-1][j] && a.charAt(k-1)==i.charAt(k+j-1);
                    fromS2 = dp[k][j-1] && b.charAt(j-1)==i.charAt(k+j-1);
                }
                dp[k][j] = fromS1 || fromS2;
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args){
        System.out.println(doStringsInterleave("bcc","bbca","bbcbcac"));
    }
}


//A=bcc
//B=bbca
//C=bbcbcac