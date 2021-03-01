package com.algorithms.interviews.fb.strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MinLengthSubstrings {
    // Add any helper functions you may need here
    int minLengthSubstring(String s, String t) {
        // Write your code here
        Map<Character, Integer> tMap = new HashMap();
        Map<Character, Integer> tOccuranceMap = new HashMap();
        char[] tChars = t.toCharArray();
        for(int i=0; i<tChars.length; i++){
            if(tMap.get(tChars[i]) == null) {
                tMap.put(tChars[i], 0);
                tOccuranceMap.put(tChars[i], 0);
            }
            tMap.put(tChars[i], tMap.get(tChars[i]) + 1);
        }
        int hare = 0;
        int tortoise = 0;
        int minLength = -1;
        int missing = t.length();
        while(hare < s.length()-1 && tortoise <= hare-t.length()){

            if(missing==0){
                if(minLength == -1){
                    minLength = hare-tortoise;
                }else{
                    if(hare-tortoise<minLength) minLength = hare-tortoise;
                }
            }
        }
        return minLength;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        String rightTick = "CORRECT";
        String wrongTick = "WRONG";
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) throws IOException {
        new MinLengthSubstrings().run();
    }
}
