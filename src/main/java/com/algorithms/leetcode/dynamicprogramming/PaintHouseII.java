package com.algorithms.leetcode.dynamicprogramming;

/**
 * 265. Paint House II
 * https://leetcode.com/problems/paint-house-ii/
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        int[][] minCostsPerColor = new int[costs.length][costs[0].length];
        for(int color=0; color<minCostsPerColor[0].length; color++){
            minCostsPerColor[0][color] = costs[0][color];
        }
        for(int house=1; house<costs.length; house++){
            for(int color=0; color<costs[0].length; color++){
                minCostsPerColor[house][color] = costs[house][color] + getMinColor(minCostsPerColor[house-1], color);
            }
        }
        return getMinColor(minCostsPerColor[costs.length-1], -1);
    }

    private int getMinColor(int[] previousHousesCost, int excludeColor){
        int min = Integer.MAX_VALUE;
        for(int color=0; color<previousHousesCost.length; color++){
            if(color == excludeColor) continue;
            min = Math.min(min, previousHousesCost[color]);
        }
        return min;
    }

    public static void main(String[] args){
        int[][] costs = {{1,5,3}, {2,9,4}};
        PaintHouseII paintHouseII = new PaintHouseII();
        System.out.println(paintHouseII.minCostII(costs));
    }
}
