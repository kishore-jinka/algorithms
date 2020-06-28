package com.algorithms.leetcode.dynamicprogramming;

/**
 * 983. Minimum Cost For Tickets
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length == 0) return 0;
        int[] dp = new int[days.length];
        dp[0] = costs[0];
        for(int i=1; i<costs.length; i++) dp[0] = Math.min(dp[0], costs[i]);
        for(int i=1; i<days.length; i++){
            //1-day pass
            int case1 = dp[i-1] + costs[0];

            //2-day pass
            int j=i-1;
            while(j>=0 && days[j] >= days[i] - 6) j = j - 1;
            int case2 = 0;
            if(j>=0){
                case2 = dp[j] + costs[1];
            }else{
                case2 = costs[1];
            }

            //3-day pass
            j=i-1;
            while(j>=0 && days[j] >= days[i] - 29) j = j - 1;
            int case3 = 0;
            if(j>=0){
                case3 = dp[j] + costs[2];
            }else{
                case3 = costs[2];
            }

            dp[i] = Math.min(case3, Math.min(case1, case2));
        }
        return dp[days.length-1];
    }

    public static void main(String[] args){
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2, 7, 15};
        MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();
        int minCost = minimumCostForTickets.mincostTickets(days, costs);
        System.out.println("minCost: " + minCost);
    }
}
