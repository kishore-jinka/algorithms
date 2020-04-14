package com.algorithms.ik.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortCharacters {

    public static List<Character> sort_array(List<Character> arr) {
        return sort(arr, 0, arr.size() - 1);
    }

    private static List<Character> sort(List<Character> toSort, int startIndex, int endIndex){
        if(startIndex < endIndex) {
            int middle = (startIndex + endIndex) / 2;
            List<Character> leftSortedArray = sort(toSort, startIndex, middle);
            List<Character> rightSortedArray = sort(toSort, middle + 1, endIndex);
            return merge(leftSortedArray, rightSortedArray);
        }
        return toSort.subList(startIndex, startIndex+1);
    }

    private static List<Character> merge(List<Character> a, List<Character> b){
        List<Character> merged = new ArrayList<Character>(a.size() + b.size());
        int i = 0, j = 0;
        while(i<a.size() && j<b.size()){
            if(a.get(i) <= b.get(j)){
                merged.add(a.get(i));
                i++;
            } else {
                merged.add(b.get(j));
                j++;
            }
        }
        if(i<a.size()){
            while(i<a.size()) {
                merged.add(a.get(i));
                i++;
            }
        }
        if(j<b.size()){
            while(j<b.size()) {
                merged.add(b.get(j));
                j++;
            }
        }
        return merged;
    }

    public static void main(String[] args){
        Character[] toSort = {'a','z','i','#','&','l','c'};
        List<Character> list = Arrays.asList(toSort);
        List<Character> sorted = sort_array(list);
        for(Character eachInt : sorted) System.out.println(eachInt);
    }
}
