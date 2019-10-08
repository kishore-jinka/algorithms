package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsets {

    /*
     * Complete the function below.
     */
    static String[] generate_all_subsets(String s) {
        List<String> stringList = new ArrayList<String>();
        generateSubstrings(0, s.toCharArray(),"", stringList);
        String[] array = new String[stringList.size()];
        return stringList.toArray(array);
    }

    static void generateSubstrings(int index, char[] charArray, String currentString, List<String> stringList){
        stringList.add(currentString);
        for(int i = index; i < charArray.length; i++){
            currentString = currentString + charArray[i];
            generateSubstrings(i + 1, charArray, currentString, stringList);
            currentString = currentString.substring(0, currentString.length() - 1);
        }
    }


    public static void main(String[] args){
        String s = "abc";
        System.out.println(Arrays.toString(generate_all_subsets(s)));
    }
}

/*
Generate All Subsets Of A Set



Problem Statement:



Given a set (in form of string s containing only distinct lowercase letters ('a' - 'z')), you have to generate ALL possible subsets of it .



Note that:

empty set is always a subset of any set.
whole set s should also be considered as its subset here.


The purpose of this problem is to learn recursion and not DP. So, you must write at least one recursive solution. After that, you can write a DP solution if you want.



Input/Output Format For The Function:



Input Format:



There is only one argument denoting string s.



Output Format:



Return array of strings res, containing ALL possible subsets of given string.



You need not to worry about order of strings in your output array. E.g. s = "a", arrays ["", "a"] and ["a", ""]  both will be accepted.



Order of characters in any subset must be same as in the input string. For s = "xy", array ["", "x", "y", "xy"] will be accepted, but ["", "x", "y", "yx"] will not be accepted.



Input/Output Format For The Custom Input:



Input Format:



The first and only line of input should contain a string s, denoting the input string.



If s = “xy”, then input should be:



xy



Output Format:



Let’s denote the size of res as m, where res is the resultant array of strings returned by the solution function.

Then, there will be m lines of output, where ith line contains string at index i of res.



For input s = “xy”, output will be:

----------- START of output -----------



x

y

xy

----------- END of output ---------------

(Note that the first line of output is an empty line, corresponding to empty set [“”].)



Constraints:

﻿﻿﻿﻿

0 <= |s| <= 20
s only contains distinct lowercase alphabetical letters ('a' - 'z').


Sample Test Cases:



Sample Input:



"xy"



Sample Output:



["", "x", "y", "xy"]



Notes:



Suggested time in interview: 20 minutes

The “Suggested Time” is the time expected to complete this question during a real-life interview, not now in homework i.e. For the first attempt of a given homework problem, the focus should be to understand what the problem is asking, what approach you are using, coding it, as well as identifying any gaps that you can discuss during a TC session. Take your time, but limit yourself to 2 one hour sessions for most problems.
 */
