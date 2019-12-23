package com.algorithms.ik.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakCount {

    /*
     * Complete the 'wordBreakCount' function below.
     *
     * The function accepts STRING_ARRAY dictionary as parameter and the original
     * string txt on which segmentation is to be performed. The function returns the
     * count of all possible segmentation arrangements
     */

    public static int wordBreakCount(List<String> dictionary, String txt) {
        if(txt == null) return 0;
        Map<Integer,List<Integer>> startAndEndMap = new HashMap();
        Boolean[] dp = new Boolean[txt.length()+1];
        dp[0] = true;
        for(int i=1; i<=txt.length(); i++){
            int j=i-1;
            dp[i] = false;
            while(j>=0){
                Boolean dpLocal = false;
                if(j==0){
                    dpLocal = dictionary.contains(txt.substring(0, i));
                }else {
                    dpLocal = dp[j] && dictionary.contains(txt.substring(j, i));
                }
                if(dpLocal){
                    dp[i] = dpLocal;
                    insertInMap(j,i,startAndEndMap);
                }
                j--;
            }
        }
        Counter c = new Counter();
        if(dp[txt.length()]){
            countPossibleSegments(txt, 0, startAndEndMap, c);
        }
        Long l = c.counter;
        Long i = 1000000007l;
        l = l%i;
        return l.intValue();
        //return (c.counter%1000000007).intValue();
    }

    private static void insertInMap(Integer start, Integer end, Map<Integer,List<Integer>> startAndEndMap){
        List<Integer> list = startAndEndMap.get(start);
        if(list == null){
            startAndEndMap.put(start, new ArrayList<Integer>());
            list = startAndEndMap.get(start);
        }
        list.add(end);
    }

    private static void countPossibleSegments(String input, Integer startIndex, Map<Integer,List<Integer>> startAndEndMap, Counter c){
        if(startAndEndMap.get(startIndex) == null){
            if(startIndex == input.length()) {
                c.counter++;
            }
            return;
        }else{
            List<Integer> endIndices = startAndEndMap.get(startIndex);
            for(Integer endIndex : endIndices){
                countPossibleSegments(input, endIndex, startAndEndMap, c);
            }
        }
    }

    private static class Counter{
        long counter = 0;
    }
}
/*
Word Break Count



Problem Statement:



You are given a dictionary set dictionary that contains dictionaryCount distinct words and another string txt. Your task is to count the possible number of the word-breaks of the txt string in such a way that all the word occur in a continuous manner in the original txt string and all these words exist in our dictionary set dictionary.



In short, you have to split the string txt using ‘ ‘(single white space delimiter) in such a way that every segment (word) exists in our dictionary.



The same word from the dictionary can be used multiple times when splitting the given string.



Example: Suppose our Dictionary is {“to”, “do”, “todo”}

and txt is “totodo” then it can also be segmented as

“to to do”. Here the word “to” from the dictionary is being used twice.



Input/Output Format For The Function:



Input Format:



The first parameter of the function that is to be implemented is an integer dictionaryCount denoting, the number of words in our dictionary. The second parameter is an array of strings dictionary, denoting the list of words in our dictionary and the last parameter is a string txt, denoting the text string that is to be segmented.



Output Format:



Return an integer denoting all different possible word-break arrangements for the txt string. This integer could be large so output it modulo 10^9 + 7.



Input/Output Format For The Custom Input:



Input Format:



The first line of the input contains one single integer denoting dictionaryCount, the number of words in our dictionary.

Next dictionaryCount lines contain strings denoting words in our dictionary. Next line contains one single string denoting the txt string.

If dictionaryCount = 2 , dictionary = [“hello” , “world”] and

txt = “helloworld” then custom input format will be:



2

hello

world

helloworld



Output Format:



Print one integer denoting all different possible word-break arrangements for the txt string.

For the above-provided custom input, output there is only one way to partition the txt string ( “hello world”), so the output will be:



1



Constraints:



1 <= dictionaryCount <= 200000
1 <= length(txt) <= 2000
1<= length of words in dictionary <= 100
All the characters in txt and words in dictionary are lower case English alphabets.


Sample Test Case:



7

kick

start

kickstart

is

awe

some

awesome

kickstartisawesome



Sample Output:



4



Explanation:



There are only 4 possible segmentations possible for the given txt and 4 % 1000000007 = 4. All four of which are mentioned below:



kick start is awe some
kick start is awesome
kickstart is awe some
kickstart is awesome


Consider first word-break arrangement: “kick start is awe some”

Here all the words: kick, start, is, awe and some exist in our dictionary and these words are continuous substrings of the txt string “kickstartisawesome”.



Similarly, other three word-breaks satisfy the same conditions and hence are valid word-breaks of the given string
 */
