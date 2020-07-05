package com.algorithms.leetcode.dynamicprogramming;

/**
 * 256. Paint House
 * https://leetcode.com/problems/paint-house/
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        int[] red = new int[costs.length];
        int[] blue = new int[costs.length];
        int[] green = new int[costs.length];
        red[0] = costs[0][0];
        blue[0] = costs[0][1];
        green[0] = costs[0][2];

        for(int i=1; i<costs.length; i++){
            red[i] = costs[i][0] + Math.min(blue[i-1], green[i-1]);
            blue[i] = costs[i][1] + Math.min(red[i-1], green[i-1]);
            green[i] = costs[i][2] + Math.min(blue[i-1], red[i-1]);
        }
        int toReturn = Math.min(red[costs.length-1], blue[costs.length-1]);
        return Math.min(toReturn, green[costs.length-1]);
    }
}
