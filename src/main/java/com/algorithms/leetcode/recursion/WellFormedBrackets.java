package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WellFormedBrackets {

    /*
     * Complete the function below.
     */
    static String[] find_all_well_formed_brackets(int n) {
        List<String> possibleStrings = new ArrayList<String>();
        formAllPossibleStrings(2*n, "", possibleStrings, n, n);
        String[] stringsToReturn = new String[possibleStrings.size()];
        for(int i=0; i<possibleStrings.size(); i++){
            stringsToReturn[i] = possibleStrings.get(i);
        }
        System.out.println(possibleStrings.size());
        return stringsToReturn;
    }

    static void formAllPossibleStrings(int n, String s, List<String> possibleStrings, int remainingLeftBrackets, int remainingRightBrackets) {
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

    public static void main(String[] args){
        System.out.println(Arrays.toString(find_all_well_formed_brackets(3)));
    }
}
/*
static void formAllPossibleStrings(int n, String s, List<String> possibleStrings, int leftBracketCount, int rightBracketCount) {
        if (leftBracketCount == 0 && rightBracketCount == 0){
            if(checkWellFormed(s))
                possibleStrings.add(s);
            return;
        }else {
            if(leftBracketCount > 0)
                formAllPossibleStrings(n-1, s + "(", possibleStrings, leftBracketCount -1, rightBracketCount);
            if(rightBracketCount > 0)
                formAllPossibleStrings(n-1, s + ")", possibleStrings, leftBracketCount, rightBracketCount -1);
        }
    }

    static boolean checkWellFormed(String s){
        Stack<Character> stack = new Stack<Character>();
        for(Character c : s.toCharArray()){
            if(stack.empty()){
                stack.push(c);
            }else{
                if(stack.peek() == '(' && c == ')'){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        return stack.empty();
    }
 */
