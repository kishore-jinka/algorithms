package com.algorithms.leetcode.bits;

/**
 * 476. Number Compliment
 * https://leetcode.com/problems/number-complement/
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
 */
public class NumberCompliment {
    public int findComplement(int num) {
        double complement = 0;
        double power = 0d;
        while(num>0){
            int reminder = num%2;
            complement = complement + (1 - reminder) * Math.pow(2d, power);
            num = num/2;
            power = power + 1;
        }
        return (int) complement;
    }

    public static void main(String[] args){
        NumberCompliment numberCompliment = new NumberCompliment();
        System.out.println(numberCompliment.findComplement(1));
    }
}
