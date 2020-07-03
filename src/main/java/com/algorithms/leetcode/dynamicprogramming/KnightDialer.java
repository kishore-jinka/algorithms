package com.algorithms.leetcode.dynamicprogramming;

/**
 * 935. Knight Dialer
 * https://leetcode.com/problems/knight-dialer/
 */
public class KnightDialer {
    public int knightDialer(int N) {
        long[][] dp = new long[N][10];
        for(int i=0; i<10; i++) dp[0][i] = 1;
        for(int level=1; level<N; level++){
                dp[level][0] = (dp[level-1][4] + dp[level-1][6]) % (1000000007);
                dp[level][1] = (dp[level-1][6] + dp[level-1][8]) % (1000000007);
                dp[level][2] = (dp[level-1][7] + dp[level-1][9]) % (1000000007);
                dp[level][3] = (dp[level-1][4] + dp[level-1][8]) % (1000000007);
                dp[level][4] = (dp[level-1][3] + dp[level-1][9] + dp[level-1][0]) % (1000000007);
                dp[level][5] = 0;
                dp[level][6] = (dp[level-1][1] + dp[level-1][7] + dp[level-1][0]) % (1000000007);
                dp[level][7] = (dp[level-1][2] + dp[level-1][6]) % (1000000007);
                dp[level][8] = (dp[level-1][1] + dp[level-1][3]) % (1000000007);
                dp[level][9] = (dp[level-1][2] + dp[level-1][4]) % (1000000007);
        }

        long total = 0;
        for(int key=0; key<10; key++){
            System.out.println("key=" + key + ", dp["+ (N-1)+"] = " + dp[N-1][key]);
            total = (total + dp[N - 1][key]) % (1000000007);
        }
        System.out.println("total: " + total);
        return (int) total;
    }

    public static void main(String[] args){
        KnightDialer knightDialer = new KnightDialer();
        System.out.println(knightDialer.knightDialer(161));
    }
}
