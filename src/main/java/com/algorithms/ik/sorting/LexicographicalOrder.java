package com.algorithms.ik.sorting;

import java.util.HashMap;
import java.util.Map;

public class LexicographicalOrder {
    /*
     * Complete the solve function below.
     * arr = [“key1 abcd”, “key2 zzz”, “key1 hello”, “key3 world”, "key1 hello"]
     */
    static String[] solve(String[] arr) {
        HashMap<String, Entry> map = new HashMap<String, Entry>();
        for(String input : arr){
            Integer firstSpace = input.indexOf(" ");
            String key = input.substring(0,input.indexOf(" ")).trim();
            String value = input.substring(firstSpace).trim();
            Entry entry = map.get(key);
            if(entry != null){
                if(value.compareToIgnoreCase(entry.getLexicon()) > 0) {
                   entry.setLexicon(value);
                }
                entry.setCount(entry.getCount() + 1);
                map.put(key, entry);
            } else {
                map.put(key, new Entry(1, value));
            }
        }
        String[] toReturn = new String[map.size()];
        int i=0;
        for(String key: map.keySet()){
            Entry entry = map.get(key);
            toReturn[i++] = key+":"+entry.getCount()+","+entry.getLexicon();
        }
        return toReturn;
    }

    public static void main(String[] args){
        //Test Case 1
        String[] arr = {"key1 abcd", "key2 zzz", "key1 hello", "key3 world", "key1 hello"};
        printArray(arr);

        //Test Case 2
        String[] arr2 = {"mark zuckerberg", "tim cook", "mark twain"};
        printArray(arr2);
    }

    private static void printArray(String[] arr){
        String[] solution = solve(arr);
        for (String keyValue: solution) {
            System.out.println(keyValue);
        }
    }

    static class Entry{
        private Integer count;
        private String lexicon;
        Entry(Integer count, String lexicon){
            this.count = count;
            this.lexicon = lexicon;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getLexicon() {
            return lexicon;
        }

        public void setLexicon(String lexicon) {
            this.lexicon = lexicon;
        }
    }
}





/*

Lexicographical Order



Problem Statement:



You are given a string array named arr, of size N, containing KEYS and VALUES separated by a space.



Your task is to find, for each unique KEY, the number of VALUES with that key and the VALUE with the highest lexicographical order (also called alphabetical order OR dictionary order).



(Have a look at the sample test cases for more clarity.)



Input/Output Format For The Function:



Input Format:



There is only one argument: String array arr.



Output Format:



Return a string array res, with an entry for each unique key. Each entry should contain key, number of values corresponding to that key and value with the highest lexicographical order in the below format:



"<KEY>:<COUNT>,<HIGHEST_LEXICOGRAPHICAL_VALUE>"



Order of the output does not matter.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain an integer N, denoting size of input array arr. In next N lines, ith line should contain a string arr[i], denoting a value at index i of arr.



If N = 5 and arr = [“key1 abcd”, “key2 zzz”, “key1 hello”,

“key3 world”, "key1 hello"], then input should be:



5

key1 abcd

key2 zzz

key1 hello

key3 world

key1 hello



Output Format:



There will be N lines of output, where ith line contains a string res[i], denoting value at index i of res.

Here, res is the result array returned by solution function.



For input N = 5 and arr = [“key1 abcd”, “key2 zzz”, “key1 hello”,

“key3 world”, "key1 hello"], output will be:



key3:1,world

key2:1,zzz

key1:3,hello



Constraints:

1 <= N <= 10^4
1 <= Length(KEYS) <= 256
1 <= Length(VALUES) <= 800
KEYS can repeat.
VALUES can repeat.
Keys and values will contain only lower case letters and numerics.


Sample Test Case:



Sample Test Case 1:



Sample Input 1:



arr = [

   “key1 abcd”,

   “key2 zzz”,

   “key1 hello”,

   “key3 world”,

   "key1 hello"

]



Sample Output 1:



One possible output (you can return strings in any order):



[

   "key1:3,hello",

   "key2:1,zzz",

   "key3:1,world"

]



Sample Test Case 2:



Sample Input 2:



arr = [

   “mark zuckerberg”,

   “tim cook”,

   “mark twain”

]



Sample Output 2:



One possible output (you can return strings in any order):



[

   "mark:2,zuckerberg",

   "tim:1,cook"

]
 */