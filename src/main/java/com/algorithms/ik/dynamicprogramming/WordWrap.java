package com.algorithms.ik.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

//TODO: INCOMPLETE
public class WordWrap {

    /*
     * Complete the 'solveBalancedLineBreaks' function below.
     *
     * The function accepts STRING ARRAY and INTEGER as parameter.
     * Return LONG.
     */

    public static long solveBalancedLineBreaks(List<String> words, int limit) {
        // Write your code here
        long highestLimit = limit ^ 3;
        long[][] dp = new long[words.size()][words.size()];
        String fitment = "";
        int line = 1;
        long cost = 0l;
        long totalCost = 0l;
        for(int row = 0; row < words.size(); row++){
            fitment = fitment + " " + words.get(row);
            if(fitment.length()>limit){
                fitment = words.get(row);
                line++;
                totalCost = totalCost + cost;
            }
            cost = (limit - fitment.trim().length()) ^ 3;
            for(int column = 0; column < words.size(); column++){
                if(row == 0 && column == 0){
                    dp[row][column] = cost;
                }else if(row == 0 && column > 0){
                    dp[row][column] = highestLimit;
                }else if(row > 0 && column == 0){
                    if(line > 1){
                        dp[row][column] = highestLimit;
                    }else{
                        dp[row][column] = cost;
                    }
                }else{
                    if(line == column + 1){
                        dp[row][column] = totalCost;
                    }else{
                        dp[row][column] = highestLimit;
                    }
                    if(row == words.size() - 1 && line == column + 1) return dp[row][column];
                }
            }
        }
        return totalCost;
    }

    public static void main(String[] args){
        List<String> words = new ArrayList<String>();
        words.add("omg");
        words.add("very");
        words.add("are");
        words.add("extreme");
        int limit = 10;
        System.out.println(solveBalancedLineBreaks(words,limit));
    }

}

/*

words = [omg, very, are, extreme]

limit = 10

 */