package com.algorithms.leetcode.dynamicprogramming;

/**
 * 790. Domino and Tromino Tiling (One of my favourites)
 * https://leetcode.com/problems/domino-and-tromino-tiling/
 *
 * F(n) = F(n-1) + F(n-2) + L(n-2) + U(n-2)
 * L(m) = F(m-1) + U(m-1)
 * U(m) = F(m-1) + L(m-1)
 *
 * F(1) = 1 | F(2) = 2
 * x        | xy  xx
 * x        | xy  yy
 *
 * L(1) = 1 | L(2) = 2 {F(1) + U(1)}
 * x        | xy   xx
 * xx       | xyy  xyy
 *
 * U(1) = 1 | U(2) = 2 {F(1) + L(1)}
 * yy       | xyy  xyy
 * y        | xy   xx
 */
public class DominoTrominoTiling {
    public int numTilings(int N) {
        long[] dp = new long[N+1];
        long[] lower = new long[N+1];
        long[] upper = new long[N+1];

        dp[0] = 0;
        dp[1] = 1;
        if(N==1) return (int)dp[1];
        dp[2] = 2;
        if(N==2) return (int)dp[2];

        lower[0] = 0;
        lower[1] = 1;
        lower[2] = 2;

        upper[0] = 0;
        upper[1] = 1;
        upper[2] = 2;

        for(int i=3; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2] + lower[i-2] + upper[i-2]) % 1000000007;
            lower[i] = (dp[i-1] + upper[i-1]) % 1000000007;
            upper[i] = (dp[i-1] + lower[i-1]) % 1000000007;
        }

        return (int) (dp[N] % 1000000007);
    }

    public static void main(String[] args){
        DominoTrominoTiling dominoTrominoTiling = new DominoTrominoTiling();
        System.out.println(dominoTrominoTiling.numTilings(60));
    }
}
