package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> possibleStrings = new ArrayList<String>();
        formAllPossibleStrings(2*n, "", possibleStrings, n, n);
        return possibleStrings;
    }

    void formAllPossibleStrings(int n, String s, List<String> possibleStrings, int remainingLeftBrackets, int remainingRightBrackets) {
        if (remainingLeftBrackets == 0 && remainingRightBrackets == 0){
            possibleStrings.add(s);
            return;
        }else if(remainingLeftBrackets <= remainingRightBrackets){
            if(remainingLeftBrackets > 0)
                formAllPossibleStrings(n-1, s + "(", possibleStrings, remainingLeftBrackets -1, remainingRightBrackets);
            if(remainingRightBrackets > 0)
                formAllPossibleStrings(n-1, s + ")", possibleStrings, remainingLeftBrackets, remainingRightBrackets -1);
        }
    }
}
