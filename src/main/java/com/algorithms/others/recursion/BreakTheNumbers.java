package com.algorithms.others.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Break a given number into numbers less than 27 and greater than 0.
*/
public class BreakTheNumbers {

    static List<String> breakNumbers(String s) {
        List<String> stringList = new ArrayList<String>();
        breakRecursively(s, 0, s.length(), "", stringList);
        return stringList;
    }

    private static void breakRecursively(String s, int position, int length, String inFix, List<String> stringList){
        if(position == length ){
            stringList.add(inFix);
        }else if(position < length-1){
            if(s.charAt(position) != '0') {
                breakRecursively(s, position + 1, length, inFix + s.charAt(position) + ",", stringList);
            }
            if(position+1 <= length-1) {
                String doubleDigitsString = s.charAt(position) + "" + s.charAt(position + 1);
                Integer doubleDigits = Integer.parseInt(doubleDigitsString);
                if(doubleDigits > 0 && doubleDigits<27) {
                    breakRecursively(s, position + 2, length, inFix + doubleDigitsString + ",", stringList);
                }
            }
        }else if(position == length-1){
            if(s.charAt(position) == '0') return;
            breakRecursively(s, position+1, length, inFix + s.charAt(position), stringList);
        }
    }

    public static void main(String[] args){
        String s = "1001";
        for(String s1: breakNumbers(s)){
            System.out.println(s1);
        }

    }

}


