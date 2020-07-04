package com.algorithms.leetcode.dynamicprogramming;

/**
 * 276. Paint Fence
 * https://leetcode.com/problems/paint-fence/
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if(n==0) return 0;
        int[] same = new int[n];
        int[] different = new int[n];
        int[] dp = new int[n];
        same[0] = 0;
        different[0] = k;
        dp[0] = k;
        for(int i=1; i<n; i++){
            same[i] = different[i-1];
            different[i] = dp[i-1] * (k - 1);
            dp[i] = same[i] + different[i];
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        PaintFence paintFence = new PaintFence();
        System.out.println(paintFence.numWays(3, 2));
    }
}
