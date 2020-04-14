package com.algorithms.leetcode.strings;

/**
 * Perform String Shift
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
 */
public class PerformStringShift {

    public String stringShift(String s, int[][] shift) {
        if(shift.length == 0) return s;
        int ones = 0;
        int zeros = 0;
        for(int[] row : shift){
            if(row[0] == 1) ones = ones + row[1];
            if(row[0] == 0) zeros = zeros + row[1];
        }
        System.out.println("ones: " + ones);
        System.out.println("zeros: " + zeros);
        if(ones > zeros){
            ones = ones - zeros;
            ones =  ones % s.length();
            System.out.println("final ones: " + ones);
            s = s.substring(s.length() - ones) + s.substring(0, s.length() - ones);
        }else if(zeros > ones){
            zeros = zeros - ones;
            zeros =  zeros % s.length();
            System.out.println("final zeros: " + zeros);
            s = s.substring(zeros) + s.substring(0, zeros);
        }
        return s;
    }

    public static void main(String[] args){
        String s = "mecsk";
        int[][] shift = {{1,4},{0,5},{0,4},{1,1},{1,5}};
        PerformStringShift performStringShift = new PerformStringShift();
        System.out.println(performStringShift.stringShift(s, shift));
    }

}

/*
Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"

Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
 */