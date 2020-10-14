package com.algorithms.leetcode.recursion;


import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> permutations = new ArrayList<String>();
        recursivePermutation(S, 0, new StringBuffer(), permutations);
        return permutations;
    }

    private void recursivePermutation(String S, int index, StringBuffer changed, List<String> permutations){

        if(index == S.length()){
            permutations.add(changed.toString());
            return;
        }

        char c = S.charAt(index);
        if(c >= 65 && c <= 90){
            char otherC = Character.toLowerCase(c);
            changed.append(otherC);
            recursivePermutation(S, index + 1, changed, permutations);
            changed.deleteCharAt(changed.length() - 1);
            changed.append(c);
            recursivePermutation(S, index + 1, changed, permutations);
            changed.deleteCharAt(changed.length() - 1);
        }else if(c >= 97 && c <= 122){
            char otherC = Character.toUpperCase(c);
            changed.append(otherC);
            recursivePermutation(S, index + 1, changed, permutations);
            changed.deleteCharAt(changed.length() - 1);
            changed.append(c);
            recursivePermutation(S, index + 1, changed, permutations);
            changed.deleteCharAt(changed.length() - 1);
        }else{
            changed.append(c);
            recursivePermutation(S, index + 1, changed, permutations);
            changed.deleteCharAt(changed.length() - 1);
        }
    }

    public static void main(String[] args){
        String S = "a1b2";
        LetterCasePermutation lcp = new LetterCasePermutation();
        List<String> permutations = lcp.letterCasePermutation(S);
        for(String s : permutations){
            System.out.println(s);
        }
    }
}
