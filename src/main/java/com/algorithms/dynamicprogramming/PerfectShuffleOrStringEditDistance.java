package com.algorithms.dynamicprogramming;

public class PerfectShuffleOrStringEditDistance {
    //returns true if shuffle is perfect shuffle of strA and strB.
    private static boolean isPerfectShuffle(String strA, String strB, String shuffle){
        boolean[][] dp = new boolean[strA.length()+1][strB.length()+1];
        for(int i=0; i<=strA.length(); i++){
            for(int j=0; j<=strB.length(); j++){
                boolean zero = i==0 || j==0;
                boolean fromA = i>0 && dp[i-1][j] && strA.charAt(i-1)==shuffle.charAt(i+j-1);
                boolean fromB = j>0 && dp[i][j-1] && strB.charAt(j-1)==shuffle.charAt(i+j-1);
                dp[i][j] = zero || fromA || fromB;
            }
        }
        return dp[strA.length()][strB.length()];
    }

    public static void main(String[] args){
        System.out.println(isPerfectShuffle("bcc","bbca","bbcbcac"));
    }
}


//A=bcc
//B=bbca
//C=bbcbcac