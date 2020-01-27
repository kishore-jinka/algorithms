package com.algorithms.ik.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: INCOMPLETE
 */
public class PalindromicDecompositionOfAString {


    static String[] generate_palindromic_decompositions(String s) {
        List<List<String>> resultsList = new ArrayList<List<String>>();
        for(int i=0; i<s.length(); i++){
            int startIndex1 = i-1;
            int endIndex1 = i+1;
            while(startIndex1 >= 0 && endIndex1 < s.length()){
                if(s.charAt(startIndex1) == s.charAt(endIndex1)){
                    startIndex1--;
                    endIndex1++;
                    if(startIndex1 < i - 1 && endIndex1 > i + 1) {
                        breakString(startIndex1 + 1, endIndex1, s, resultsList);
                    }
                    continue;
                }else{
                    break;
                }
            }
            int startIndex2 = i;
            int endIndex2 = i+1;
            while(startIndex2 >= 0 && endIndex2 < s.length()){
                if(s.charAt(startIndex2) == s.charAt(endIndex2)){
                    startIndex2--;
                    endIndex2++;
                    if(startIndex2 < i && endIndex2 > i+1) {
                        breakString(startIndex2 + 1, endIndex2, s, resultsList);
                    }
                    continue;
                }else{
                    break;
                }
            }
        }
        breakString(s.length(), s.length(), s, resultsList);
        return combineStrings(resultsList);
    }

    private static void breakString(int startIndex, int endIndex, String s, List<List<String>> resultsList){
        List<String> stringList = new ArrayList<String>();
        int i=0;
        while(i<startIndex){
            stringList.add(s.substring(i,i+1));
            i++;
        }
        if(startIndex < endIndex) stringList.add(s.substring(startIndex, endIndex));
        i=endIndex;
        while(i<s.length()){
            stringList.add(s.substring(i,i+1));
            i++;
        }
        resultsList.add(stringList);
    }

    private static String[] combineStrings(List<List<String>> resultsList){
        String[] stringList = new String[resultsList.size()];
        int i = 0;
        for(List<String> resultList : resultsList){
            String toAdd = "";
            for(String s : resultList){
                toAdd = toAdd + s + "|";
            }
            stringList[i++] = toAdd.substring(0,toAdd.length()-1);
        }
        return stringList;
    }

    public static void main(String[] args){
        String s = "abracadabra";
        String[] partitionList = generate_palindromic_decompositions(s);
        for(String partition : partitionList){
            System.out.println(partition);
        }
    }
}
