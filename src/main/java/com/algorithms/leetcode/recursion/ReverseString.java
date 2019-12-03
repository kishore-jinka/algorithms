package com.algorithms.leetcode.recursion;

/**
 * Reverse a char[] set through recursion
 */
public class ReverseString {
    public void reverseString(char[] s) {
        helper(0, s);
    }

    private void helper(int index, char[] charArray) {
        if (charArray == null || index >= charArray.length/2) {
            return;
        }
        helper(index + 1, charArray);
        //System.out.print(str[index]);
        swap(index, charArray.length - index -1, charArray);
    }

    private void swap(int from, int to, char[] charArray){
        char temp = charArray[from];
        charArray[from] = charArray[to];
        charArray[to] = temp;
    }

    public static void main(String[] args){
        ReverseString rs = new ReverseString();
        //char[] input = {'h','e','l','l','o'};
        char[] input = {'H','a','n','n','a','h'};
        rs.reverseString(input);
        System.out.println(input);
    }
}

/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.



Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */

