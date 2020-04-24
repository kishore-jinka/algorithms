package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap();
        boolean isHappy = false;
        while(!isHappy) {
            int squareSum = 0;
            while (n != 0) {
                int lastDigit = n % 10;
                squareSum = squareSum + lastDigit*lastDigit;
                n = n/10;
            }
            if(squareSum == 1) {
                isHappy = true;
                break;
            }
            if(map.get(squareSum) == null){
                map.put(squareSum, 0);
            }
            map.put(squareSum, map.get(squareSum) + 1);
            if(map.get(squareSum) > 1) {
                break;
            }
            n = squareSum;
        }
        return isHappy;
    }
}
