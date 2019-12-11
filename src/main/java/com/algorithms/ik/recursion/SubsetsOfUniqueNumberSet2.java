package com.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsOfUniqueNumberSet2 {

    /*
     * Complete the function below.
     */
    static List<List<Integer>> generateAllSubsets(List<Integer> integerList) {
        List<List<Integer>> subsetList = new ArrayList<List<Integer>>();
        generateAllSubsetsRecursive(0, integerList,new ArrayList<Integer>(), subsetList);
        return subsetList;
    }

    static void generateAllSubsetsRecursive(int index, List<Integer> integerList, List<Integer> currentList, List<List<Integer>> subsetList){
        subsetList.add(currentList);
        List<Integer> newCurrentList = new ArrayList<Integer>(currentList);
        for(int i = index; i < integerList.size(); i++){
            newCurrentList.add(integerList.get(i));
            generateAllSubsetsRecursive(i + 1, integerList, newCurrentList, subsetList);
            int newSize = newCurrentList.size();
            newCurrentList.remove(newSize-1);
            //newCurrentList.remove(newSize-2);
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
