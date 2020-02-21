package com.algorithms.ik.strings;

/**
 *
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        return isMatchRecursive(s, p, 0, 0);
    }

    private boolean isMatchRecursive(String input, String regex, int inputIndex, int regexIndex){
        if(regexIndex == regex.length()) return inputIndex == input.length();
        if(inputIndex > input.length()) return false;
        if(inputIndex < input.length() && input.charAt(inputIndex) == regex.charAt(regexIndex)){
            return isMatchRecursive(input, regex, inputIndex+1, regexIndex+1);
        }
        if(regex.charAt(regexIndex) == '*'){
            return  isMatchRecursive(input, regex, inputIndex, regexIndex + 1)
                    || isMatchRecursive(input, regex, inputIndex + 1, regexIndex);
        }
        return false;
    }

    public static void main(String[] args){
        String input = "aa";
        String regex = "a*c";
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.println(rem.isMatch(input, regex));
    }
}

/*
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */