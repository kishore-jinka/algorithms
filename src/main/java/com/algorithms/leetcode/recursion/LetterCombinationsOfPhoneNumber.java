package com.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2905/
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> combinationsList = new ArrayList<String>();
        if(digits.trim().length() == 0){
            return combinationsList;
        }
        StringBuilder stringBuilder = new StringBuilder();
        letterCombinationsRecursive(0, digits.toCharArray(), stringBuilder, combinationsList);
        return combinationsList;
    }

    private void letterCombinationsRecursive(int index, char[] digits, StringBuilder stringBuilder, List<String> combinationsList){
        if(stringBuilder.length() == digits.length){
            combinationsList.add(stringBuilder.toString());
            return;
        }
        for(int i=index; i<digits.length; i++){
            char[] letters = getLetters(digits[i]);
            if(letters != null) {
                for (int j = 0; j < letters.length; j++) {
                    stringBuilder.append(letters[j]);
                    letterCombinationsRecursive(i + 1, digits, stringBuilder, combinationsList);
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
    }

    private char[] getLetters(char digit){
        if(digit=='2'){
            char[] array = {'a', 'b', 'c'};
            return array;
        }else if(digit=='3'){
            char[] array = {'d', 'e', 'f'};
            return array;
        }else if(digit=='4'){
            char[] array = {'g', 'h', 'i'};
            return array;
        }else if(digit=='5'){
            char[] array = {'j', 'k', 'l'};
            return array;
        }else if(digit=='6'){
            char[] array = {'m', 'n', 'o'};
            return array;
        }else if(digit=='7'){
            char[] array = {'p', 'q', 'r', 's'};
            return array;
        }else if(digit=='8'){
            char[] array = {'t', 'u', 'v'};
            return array;
        }else if(digit=='9'){
            char[] array = {'w', 'x', 'y', 'z'};
            return array;
        }

        return null;
    }

    public static void main(String[] args){
        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
        List<String> combinations = letterCombinationsOfPhoneNumber.letterCombinations("23");
        for(String s : combinations){
            System.out.println(s);
        }
    }
}
