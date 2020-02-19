package com.algorithms.leetcode.greedy;

/**
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        return removeKdigitsStringBuilder(new StringBuilder(num), k).toString();
    }

    public StringBuilder removeKdigitsStringBuilder(StringBuilder num, int k) {
        if(k == 0) return removeLeadingZero(num);
        if(k >= num.length()) return new StringBuilder("0");
        int flipIndex = getFlixIndex(num);
        return removeKdigitsStringBuilder(num.deleteCharAt(flipIndex), k-1);
    }

    private int getFlixIndex(StringBuilder num){
        for(int i=0; i<num.length() - 1; i++){
            char numI = num.charAt(i);
            char numNext = num.charAt(i+1);
            if(numI > numNext) return i;
        }
        return num.length() - 1;
    }

    private StringBuilder removeLeadingZero(StringBuilder num){
        if(num.length() > 1 && num.substring(0,1).equals("0")){
            return removeLeadingZero(num.deleteCharAt(0));
        }else{
            return num;
        }
    }

    public static void main(String[] args){
        String num = "10";
        int k = 2;
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
