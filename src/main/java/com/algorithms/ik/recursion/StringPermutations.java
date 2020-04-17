package com.algorithms.ik.recursion;

/**
 * Find the permutations of a given string
 */
public class StringPermutations {

    static void printPermutation(String str, String ans){
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutation(ros, ans + ch);
        }
    }

    public static void main(String[] args){
        String s = "123";
        printPermutation(s, "");
    }
}
