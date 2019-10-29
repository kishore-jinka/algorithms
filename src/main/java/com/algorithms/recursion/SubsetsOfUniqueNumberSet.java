package com.algorithms.recursion;

import java.util.*;

public class SubsetsOfUniqueNumberSet {

    /*
     * Complete the function below.
     */
    static List<String> generateAllSubsets(List<Integer> integerList) {
        List<String> subsetList = new ArrayList<String>();
        generateAllSubsetsRecursive(0, integerList,"", subsetList);
        return subsetList;
    }

    static void generateAllSubsetsRecursive(int index, List<Integer> integerList, String currentString, List<String> subsetList){
        subsetList.add(currentString);
        for(int i = index; i < integerList.size(); i++){
            currentString = currentString + "," + integerList.get(i);
            generateAllSubsetsRecursive(i + 1, integerList, currentString, subsetList);
            currentString = currentString.substring(0, currentString.length() - 1);
        }
    }


    public static void main(String[] args){
        Set<Integer> integerSet = new HashSet<Integer>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.addAll(integerSet);
        System.out.println(generateAllSubsets(integerList));
    }
}
