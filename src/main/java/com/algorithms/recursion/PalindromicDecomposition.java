package com.algorithms.recursion;

public class PalindromicDecomposition {

    /*
     * Complete the function below.
     */
    static String[] generate_palindromic_decompositions(String s) {
        return null;
    }

}

/*
Palindromic Decomposition Of A String



Problem Statement:



A palindromic decomposition of string is a decomposition of the string into substrings, such that all those substrings are valid palindromes.



Given a string s, you have to find ALL possible palindromic decompositions of it.



Note that string s itself is also a substring of s.



The purpose of this problem is to learn recursion and not DP. So, you must write at least one recursive solution. After that, you can write a DP solution if you want.



Input/Output Format For The Function:



Input Format:



There is only one argument: string s.



Output Format:



Return array of string res, containing ALL possible palindromic decompositions of given string.



To separate substrings in the decomposed string, use '|' as a separator between them. (Look at the sample test cases for more clarity.)



Note that:

You need not to worry about the order of strings in your output array. Like for s = "aa", arrays ["a|a", "aa"] and ["aa", "a|a"] both will be accepted.
In any string in your returned array res, order of characters should remain same as in given string. (i.e. for s = "ab" you should return ["a|b"] and not ["b|a"].)
Any string in the returned array should not contain any spaces. e.g. s = "ab" then ["a|b"] is expected, ["a |b"] or ["a| b"] or ["a | b"] will give wrong answer.


Input/Output Format For The Custom Input:



Input Format:



The first and only line of input should contain a string s, denoting the input string.



If s = “abracadabra”, then input should be:



abracadabra



Output Format:



Let’s denote size of res array as m, where res is the resultant array of string returned by solution function.

Then, there will be m lines of output, where ith line contains a string res[i], denoting string at index i of res.



For input s = “abracadabra”, output will be:



a|b|r|a|c|ada|b|r|a

a|b|r|aca|d|a|b|r|a

a|b|r|a|c|a|d|a|b|r|a



Constraints:

1 <= |s| <= 20
s only contains lowercase letters ('a' - 'z').


Sample Test Cases:



Sample Input:



"abracadabra"



Sample Output:



[

   "a|b|r|a|c|a|d|a|b|r|a",

   "a|b|r|a|c|ada|b|r|a",

   "a|b|r|aca|d|a|b|r|a"

]



Notes:

Suggested time in interview: 40 minutes

The “Suggested Time” is the time expected to complete this question during a real-life interview, not now in homework i.e. For the first attempt of a given homework problem, the focus should be to understand what the problem is asking, what approach you are using, coding it, as well as identifying any gaps that you can discuss during a TC session. Take your time, but limit yourself to 2 one hour sessions for most problems.
 */
