package com.algorithms.leetcode.greedy;

/**
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 * //INCOMPLETE
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        String toReturn = "0";
        if(k >= num.length()) return toReturn;
        if(k == 1){
            if(num.length() > 2 && num.charAt(1) == '0') return num.substring(2);
            int highestNumber = 0;
            int position = -1;
            for (int i = 0; i < num.length(); i++) {
                int digit = Integer.parseInt(num.substring(i, i + 1));
                if (digit > highestNumber){
                    highestNumber = digit;
                    position = i;
                }
            }
            if(position == num.length() - 1){
                return num.substring(0, position);
            }else if(position == 0){
                return num.substring(1);
            }else{
                return num.substring(0,position) + num.substring(position+1);
            }

        }
        if(k > 1 && k < num.length()) {
            int lowestNumber = 9;
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
        }

        return toReturn;
    }

    private String removeLeadingZero(String num){

    }

    public static void main(String[] args){
        String num = "1173";
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
