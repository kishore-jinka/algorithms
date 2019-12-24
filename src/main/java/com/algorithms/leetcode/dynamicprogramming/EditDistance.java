package com.algorithms.leetcode.dynamicprogramming;

/**
 * 72. Edit Distance //TODO
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {

    // word1 to change to word2
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length()+1][word1.length()+1];
        dp[0][0] = 0;
        for(int column=1; column<=word1.length(); column++){ //along row 0
            dp[0][column] = column;
        }
        for(int row=1; row<=word2.length(); row++){ //along column 0
            dp[row][0] = row;
        }
        for(int row=1; row<=word2.length(); row++){
            for(int column=1; column<=word1.length(); column++){
                if(word1.charAt(column-1) == word2.charAt(row-1)){
                    dp[row][column] = dp[row-1][column-1];
                }else{
                    dp[row][column] = getMinimum(dp[row-1][column-1], dp[row-1][column], dp[row][column-1]) + 1;
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }

    private int getMinimum(int a, int b, int c){
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    public static void main(String[] args){
        String word1 = "intention";
        String word2 = "execution";
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance(word1, word2));
    }

}
