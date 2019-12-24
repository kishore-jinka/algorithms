package com.algorithms.ik.dynamicprogramming;

public class LevenshteinDistance {
    /*
     * Complete the levenshteinDistance function below.
     */
    static int levenshteinDistance(String strWord1, String strWord2) {
        int[][] dp = new int[strWord2.length()+1][strWord1.length()+1];
        dp[0][0] = 0;
        for(int column=1; column<=strWord1.length(); column++){ //along row 0
            dp[0][column] = column;
        }
        for(int row=1; row<=strWord2.length(); row++){ //along column 0
            dp[row][0] = row;
        }
        for(int row=1; row<=strWord2.length(); row++){
            for(int column=1; column<=strWord1.length(); column++){
                if(strWord1.charAt(column-1) == strWord2.charAt(row-1)){
                    dp[row][column] = dp[row-1][column-1];
                }else{
                    dp[row][column] = getMinimum(dp[row-1][column-1], dp[row-1][column], dp[row][column-1]) + 1;
                }
            }
        }
        return dp[strWord2.length()][strWord1.length()];
    }

    private static int getMinimum(int a, int b, int c){
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
}

/*
Levenshtein Distance



Problem Statement:



Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)



You have the following 3 operations permitted on a word:



a) Insert a character

b) Delete a character

c) Replace a character



The minimum no of steps required to convert word1 to word2 with the given set of allowed operations is called edit distance.



e.g. Minimum edit distance between the words 'kitten' and 'sitting', is 3.



kitten → sitten (substitution of "s" for "k")

sitten → sittin (substitution of "i" for "e")

sittin → sitting (insertion of "g" at the end)



Read more about edit distance here:

https://en.wikipedia.org/wiki/Edit_distance



Input/Output Format For The Function:



Input Format:



You will be given two strings word1 and word2.



Output Format:



Return an integer editDist, denoting the edit distance between given two input strings.



Input/Output Format For The Custom Input:



Input Format:



The first line should contain a string denoting word1.

The second line should contain a string denoting word2.



If word1 = “cat” and word2 = “bat”, then input should be:



cat

bat



Output Format:



There will be one line, containing an integer editDist, denoting the result returned by solution function.



For input word1 = “cat” and word2 = “bat”, output will be:



1



Constraints:

1 <= length(word1), length(word2) <= 1000
word1 and word2 contains lower case alphabets from a to z.


Sample Test Cases:



Sample Test Case 1:



Sample Input 1:



cat

bat



Sample Output 1:



1



Explanation 1:



1: Replace c with b.



Sample Test Case 2:



Sample Input 2:



qwe

q



Sample Output 2:



2



Explanation 2:



1: Add w

2: Add e
 */
