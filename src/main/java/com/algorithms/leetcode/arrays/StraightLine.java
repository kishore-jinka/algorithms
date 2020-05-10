package com.algorithms.leetcode.arrays;

/**
 * 1232. Check If It Is a Straight Line
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
 */
public class StraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 0) return false;
        if(coordinates.length > 0 && coordinates.length <3) return true;
        boolean haveSameX = true;
        boolean haveSameY = true;
        for(int i=1; i<coordinates.length; i++){
            haveSameX = haveSameX && (coordinates[i][0] == coordinates[0][0]);
            haveSameY = haveSameY && (coordinates[i][1] == coordinates[0][1]);
        }
        if(haveSameX || haveSameY) return true;
        boolean haveSameSlope = true;
        for(int i=2; i<coordinates.length; i++){
            int product1 = (coordinates[i][1] - coordinates[0][1]) * (coordinates[1][0] - coordinates[0][0]);
            int product2 = (coordinates[1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[0][0]);
            haveSameSlope = haveSameSlope && (product1 == product2);
            if(!haveSameSlope) return haveSameSlope;
        }
        return haveSameSlope;
    }
}
