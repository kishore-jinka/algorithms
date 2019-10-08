package com.algorithms.dynamicprogramming;

public class Robbery {
    // Complete the maxStolenValue function below.
    static int maxStolenValue(int[] values) {
        if(values.length == 0) return 0;
        int[] dp = new int[values.length + 1];
        dp[0] = 0;
        dp[1] = values[0];
        for(int i=2; i<=values.length; i++){
            int value1 = values[i-1] + dp[i-2];
            int value2 = values[i-2];
            if(i>=3) value2 += dp[i-3];
            dp[i] = Math.max(value1, value2);
        }
        return dp[values.length];
    }

    public static void main(String[] args){
        //int[] values = {6, 1, 2, 7};
        int[] values = {1, 2, 4, 5, 1};
        System.out.println(maxStolenValue(values));
    }
}

/*
Robbery



Problem Statement:



There are n houses built in a line, each of which contains some value in it. A thief is going to steal the maximal value in these houses, but he cannot steal in two adjacent houses because the owner of a stolen house will tell his two neighbors on the left and right side. What is the maximal stolen value?



For example, if there are four houses with values [6, 1, 2, 7], the maximal stolen value is 13, when the first and fourth houses are stolen.



Input/Output Format For The Function:



Input Format:



You will be given an array of integer values, containing the value in each house.



Output Format:



Return an integer max, denoting the maximum possible robbery.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain a number n, denoting the number of houses. In next n lines, ith line should contain a number values[i], denoting ith index entry in values, i=(0,1,...,n-1).



If n = 4 and values = [6, 1, 2, 7], then input should be:



4

6

1

2

7



Output Format:



There will be one line, containing a number max, denoting the result returned by solution function.



For input n = 4 and values = [6, 1, 2, 7], output will be:



13



Constraints:



1 <= n <= 10^5
1 <= values[i] <= 10^4


Sample Test Case:



Sample Test Case 1:



Sample Input 1:



values = [6, 1, 2, 7]



Sample Output 1:



13



Explanation 1:



Steal from the first and the last house.



Sample Test Case 2:



Sample Input 2:



values = [1, 2, 4, 5, 1]



Sample Output 2:



7



Explanation 2:



Steal from the second and the fourth house.
 */
