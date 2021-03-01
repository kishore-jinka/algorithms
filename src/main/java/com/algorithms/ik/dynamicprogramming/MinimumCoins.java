package com.algorithms.ik.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class MinimumCoins {

    /*
     * Complete the 'minimum_coins' function below.
     *
     * The function accepts INTEGER ARRAY and INTEGER as parameter.
     * Return INTEGER.
     */
    public static int minimum_coins(List<Integer> coins, int value) {
        // Write your code here
        int[] dp = new int[value+1];
        dp[0] = 0;
        for(int i=1; i<=value; i++){
            int min = Integer.MAX_VALUE;
            for(int c : coins){
                if(c<=i){
                    int count = dp[i-c] + 1;
                    if(count < min) min = count;
                }
            }
            dp[i] = min;
        }
        return dp[value];
    }

    public static void main(String[] args){
        List<Integer> coins = Arrays.asList(1, 3, 5);
        int value = 9;
        System.out.println(minimum_coins(coins, value));
    }
}
/*
Minimum Coins



Problem Statement:



Every currency system has a fixed denomination system such that a given amount of change can be expressed as the sum of these denominations.



Given coins for a currency system with positive integral values C1, C2, C3...........Cn with an infinite supply of each type of coin and a positive integer value. You have to make value using a minimal number of coins.



It is guaranteed that there will be always a coin with value 1 so a solution always exists.



Input/Output Format For The Function:



Input Format:



First is an integer array of values of coins and second is a positive integer value denoting the change you have to make.



Output Format:



Return an integer representing the minimum number of coins required.



Input/Output Format For The Custom Input:



Input Format:



The first line of the input contains an integer n, denoting no. of coins denominations. In the next n lines, the ith line contains an integer coin denoting coins[i]. The n+2 th line of the input contains an integer value, denoting value for which coins denominations to found.



If coins=[1, 3, 5], value=9, then input should be:



3

1

3

5

9



Output Format:



The one and only line of output will contain a single integer representing the minimum number of coins required to make value.



For input coins=[1, 3, 5], value=9, result will be:



3



Constraints:

1 <= length of array of coins <= 100.
1 <= value <= 10000.
1 <= coins[i] <= 100 for 0 <= i < length of array of coins.
Coins array will always have unique coin denomination values.


Sample Test Case:



Sample Input:



3

1

3

5

9


Sample Output:



3



Explanation:



For denominations of coins [1, 3, 5] and as we have every denomination in the infinite count. We want to make 9 using given denominations. So all possible unique ways to generate 9 are:

[1, 1, 1, 1, 1, 1, 1, 1, 1]

[1, 1, 1, 1, 1, 1, 3]

[1, 1, 1, 1, 5]

[1, 1, 1, 3, 3]

[1, 3, 5]

[3, 3, 3]



And as [1, 3, 5] and [3, 3, 3] requires only 3 coins to make 9 and which is minimum from all other cases. Hence our answer is 3.
 */
