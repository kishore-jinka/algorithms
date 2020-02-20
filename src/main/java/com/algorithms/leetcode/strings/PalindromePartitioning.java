package com.algorithms.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/
 * TODO: INCOMPLETE
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> resultsList = new ArrayList<List<String>>();
        for(int i=0; i<s.length(); i++){
            int startIndex1 = i-1;
            int endIndex1 = i+1;
            while(startIndex1 >= 0 && endIndex1 < s.length()){
                if(s.charAt(startIndex1) == s.charAt(endIndex1)){
                    startIndex1--;
                    endIndex1++;
                    if(startIndex1 < i - 1 && endIndex1 > i + 1) {
                        breakString(startIndex1 + 1, endIndex1, s, resultsList);
                    }
                    continue;
                }else{
                    break;
                }
            }
            int startIndex2 = i;
            int endIndex2 = i+1;
            while(startIndex2 >= 0 && endIndex2 < s.length()){
                if(s.charAt(startIndex2) == s.charAt(endIndex2)){
                    startIndex2--;
                    endIndex2++;
                    if(startIndex2 < i && endIndex2 > i+1) {
                        breakString(startIndex2 + 1, endIndex2, s, resultsList);
                    }
                    continue;
                }else{
                    break;
                }
            }
        }
        breakString(s.length(), s.length(), s, resultsList);
        return resultsList;
    }

    private void breakString(int startIndex, int endIndex, String s, List<List<String>> resultsList){
        List<String> stringList = new ArrayList<String>();
        int i=0;
        while(i<startIndex){
            stringList.add(s.substring(i,i+1));
            i++;
        }
        if(startIndex < endIndex) stringList.add(s.substring(startIndex, endIndex));
        i=endIndex;
        while(i<s.length()){
            stringList.add(s.substring(i,i+1));
            i++;
        }
        resultsList.add(stringList);
    }

    public static void main(String[] args){
        String s = "cbbbcc";
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> palindromeList = palindromePartitioning.partition(s);
        for(List<String> list : palindromeList){
            System.out.println(list);
        }
    }

}

/*
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

//        List<List<String>> palindromeList = new ArrayList<List<String>>();
//        List<String> list1 = new ArrayList<String>();
//        list1.add("aa");
//        list1.add("b");
//        palindromeList.add(list1);
//        List<String> list2 = new ArrayList<String>();
//        list2.add("a");
//        list2.add("a");
//        list2.add("b");
//        palindromeList.add(list2);
 */
