package com.algorithms.ik.dynamicprogramming;

import com.algorithms.leetcode.dynamicprogramming.WordBreakII;

import java.util.*;

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
        System.out.println(startAndEndMap);
        Long counterValue = 0l;
        if(dp[txt.length()]){
            counterValue = countPossibleSegments(txt.length(), startAndEndMap);
        }else{
            return 0;
        }
        Long moduloNumber = 1000000007l;
        counterValue = counterValue % moduloNumber;
        return counterValue.intValue();
    }

    private static void insertInMap(Integer start, Integer end, Map<Integer,List<Integer>> startAndEndMap){
        List<Integer> list = startAndEndMap.get(end);
        if(list == null){
            startAndEndMap.put(end, new ArrayList<Integer>());
            list = startAndEndMap.get(end);
        }
        list.add(start);
    }

    private static long countPossibleSegments(Integer endIndex, Map<Integer,List<Integer>> startAndEndMap){
        Queue<Integer> queue = new LinkedList();
        Set<Integer> set = new HashSet();
        set.add(endIndex);
        queue.add(endIndex);
        long counter = 0l;
        while(!queue.isEmpty()){
            Integer next = queue.poll();
            List<Integer> startIndices = startAndEndMap.get(next);
            if(counter == 0 && startIndices.size()>0) counter = 1l;
            if(startIndices != null) {
                counter = counter * startIndices.size();
                for(int startIndex : startIndices) {
                    if (set.add(startIndex)) queue.addAll(startIndices);
                }
            }
        }
        return counter;
    }

    public static void main(String[] args){
        WordBreakCount wbc = new WordBreakCount();
        String s = "kickstartisawesome";
        List<String> wordDict = new ArrayList();
        wordDict.add("kick");
        wordDict.add("start");
        wordDict.add("kickstart");
        wordDict.add("is");
        wordDict.add("awe");
        wordDict.add("some");
        wordDict.add("awesome");
        int count = wbc.wordBreakCount(wordDict, s);
        System.out.println(count);
    }
}

// 18, 14 11, 9, 4 0,
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
