package com.algorithms.leetcode.greedy;

/**
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 * //INCOMPLETE
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        if(num.length() == 1 && k == 1) return "0";
        String toReturn = null;
        int lowestNumber = 9;
        if(k == 1 && num.length() > 1){
            int high = 0;
            int index = -1;
            for (int i = 0; i < num.length(); i++) {
                int digit = Integer.parseInt(num.substring(i, i + 1));
                if (digit > high){
                    high = digit;
                    index = i;
                }
            }
            return num.replaceFirst(String.valueOf(high),"");
        }else if(k < num.length()) {
            for (int i = 0; i <= k; i++) {
                int digit = Integer.parseInt(num.substring(i, i + 1));
                if (digit < lowestNumber) lowestNumber = digit;
            }
            if(k+1 == num.length()){
                toReturn = String.valueOf(lowestNumber);
            }else {
                toReturn = num.substring(k + 1);
                if (lowestNumber > 0) toReturn = lowestNumber + toReturn;
            }
            return toReturn;
        }else if(k == num.length()){
            for (int i = 0; i < k; i++) {
                int digit = Integer.parseInt(num.substring(i, i + 1));
                if (digit < lowestNumber) lowestNumber = digit;
            }
            toReturn = String.valueOf(lowestNumber);
            return toReturn;
        }
        return toReturn;
    }

    public static void main(String[] args){
        String num = "10";
        int k = 1;
        RemoveKDigits removeDigits = new RemoveKDigits();
        System.out.println(removeDigits.removeKdigits(num,k));
    }


}

/*
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */