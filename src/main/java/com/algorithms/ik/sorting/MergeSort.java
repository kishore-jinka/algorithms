package com.algorithms.ik.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static List<Integer> merge_sort(List<Integer> arr) {
        return sort(arr, 0, arr.size() -1);
    }

    private static List<Integer> sort(List<Integer> toSort, int startIndex, int endIndex){
        if(startIndex < endIndex) {
            int middle = (startIndex + endIndex) / 2;
            List<Integer> leftSortedArray = sort(toSort, startIndex, middle);
            List<Integer> rightSortedArray = sort(toSort, middle + 1, endIndex);
            return merge(leftSortedArray, rightSortedArray);
        }
        return toSort.subList(startIndex, startIndex+1);
    }

    private static List<Integer> merge(List<Integer> a, List<Integer> b){
        List<Integer> merged = new ArrayList(a.size() + b.size());
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
        Integer[] toSort = {34, 43, 24, 67, 82, 67, 44, 22, 99, 1, 22};
        //Integer[] toSort = {4,3,2,1};
        List<Integer> list = Arrays.asList(toSort);
        //Integer[] sorted = sort(toSort, 0, toSort.length -1);
        List<Integer> sorted = merge_sort(list);
        for(int eachInt : sorted) System.out.println(eachInt);
    }
}
