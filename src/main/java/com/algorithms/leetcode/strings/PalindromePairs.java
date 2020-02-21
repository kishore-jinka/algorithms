package com.algorithms.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 336. Palindrome Pairs
 * https://leetcode.com/problems/palindrome-pairs/
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairsList = new ArrayList<List<Integer>>();

        return pairsList;
    }

    public static void main(String[] args){
        String[] input = {"abcd","dcba","lls","s","sssll"};
        PalindromePairs palindromePairs = new PalindromePairs();
        List<List<Integer>> pairsList = palindromePairs.palindromePairs(input);
        for(List<Integer> pair : pairsList){
            System.out.println(pair);
        }
    }
}

/*
Example 1:
Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:
Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]

List<Integer> pairs0 = new ArrayList<Integer>();
        pairs0.add(0);
        pairs0.add(1);
        List<Integer> pairs1 = new ArrayList<Integer>();
        pairs1.add(1);
        pairs1.add(0);
        List<Integer> pairs2 = new ArrayList<Integer>();
        pairs2.add(3);
        pairs2.add(2);
        List<Integer> pairs3 = new ArrayList<Integer>();
        pairs3.add(2);
        pairs3.add(4);
        pairsList.add(pairs0);
        pairsList.add(pairs1);
        pairsList.add(pairs2);
        pairsList.add(pairs3);
 */