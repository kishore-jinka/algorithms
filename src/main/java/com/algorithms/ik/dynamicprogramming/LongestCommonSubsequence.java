package com.algorithms.ik.dynamicprogramming;

public class LongestCommonSubsequence {

    public static String lcs(String a, String b) {
        if(a == null || a.trim().length() == 0 || b == null || b.trim().length() == 0) return "-1";
        String[][] dp = new String[a.length()+1][b.length()+1];
        dp[0][0] = "";
        for(int column = 1; column <= b.length(); column++){
            dp[0][column] = "";
        }
        for(int row = 1; row <= a.length(); row++){
            dp[row][0] = "";
        }
        for(int row=1; row<=a.length(); row++){
            for(int column=1; column<=b.length(); column++){
                if (a.charAt(row-1) == b.charAt(column-1)) {
                    dp[row][column] =  dp[row-1][column-1] + a.charAt(row-1);
                }else{
                    if(dp[row-1][column].length() > dp[row][column-1].length()){
                        dp[row][column] = dp[row-1][column];
                    }else{
                        dp[row][column] = dp[row][column-1];
                    }
                }
            }
        }
        if(dp[a.length()][b.length()].length() == 0) return "-1";
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args){
        String text1 = "ABC";
        String text2 = "DEF";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.lcs(text1, text2));
    }

}
