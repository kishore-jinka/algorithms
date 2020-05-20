package com.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsets {

    /*
     * Complete the function below.
     */
    static String[] generate_all_subsets(String s) {
        List<String> stringList = new ArrayList<String>();
        generateSubstrings(0, s.toCharArray(),"", stringList);
        String[] array = new String[stringList.size()];
        return stringList.toArray(array);
    }

    static void generateSubstrings(int index, char[] charArray, String currentString, List<String> stringList){
        stringList.add(currentString);
        for(int i = index; i < charArray.length; i++){
            currentString = currentString + charArray[i];
            generateSubstrings(i + 1, charArray, currentString, stringList);
            currentString = currentString.substring(0, currentString.length() - 1);
        }
    }


    public static void main(String[] args){
        String s = "abc";
        System.out.println(Arrays.toString(generate_all_subsets(s)));
    }
}