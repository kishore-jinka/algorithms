package com.algorithms.ik.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateNumeronyms {

    /*
        Example
        Input: “nailed”
        Output: ["n4d", "na3d", "n3ed", "n2led", "na2ed", "nai2d"]
     */
    static String[] neuronyms(String word) {
        List<String> neuronymsList = new ArrayList();
        if(word.length()<=3){
            return new String[0];
        }
        for(int i=1; i<word.length()-1; i++){
            for(int j=i+2; j<word.length(); j++){
                neuronymsList.add(word.substring(0, i) + (j-i) + word.substring(j));
            }
        }
        String[] neuronymsArray = new String[neuronymsList.size()];
        for(int i=0; i<neuronymsList.size(); i++){
            neuronymsArray[i] = neuronymsList.get(i);
        }
        return neuronymsArray;
    }

    public static void main(String[] args){
        String input = "nailed";
        String[] neuronymsArray = neuronyms(input);
        for(String s : neuronymsArray) System.out.println(s);
    }
}
