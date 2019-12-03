package com.algorithms.ik.sorting;

public class MergeSort {

    private static int[] merge(int[] a, int[] b){
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, m = 0;
        while(i<a.length && j<b.length){
            if(a[i] <= b[j]){
                merged[m++] = a[i++];
            } else {
                merged[m++] = b[j++];
            }
        }
        if(i<a.length){
            while(i<a.length) merged[m++] = a[i++];
        }
        if(j<b.length){
            while(j<b.length) merged[m++] = b[j++];
        }
        return merged;
    }

    private static int[] sort(int[] toSort, int startIndex, int endIndex){
        if(startIndex < endIndex) {
            int middle = (startIndex + endIndex) / 2;
            int[] leftSortedArray = sort(toSort, startIndex, middle);
            int[] rightSortedArray = sort(toSort, middle + 1, endIndex);
            return merge(leftSortedArray, rightSortedArray);
        }
        return new int[]{toSort[startIndex]};
    }

    public static void main(String[] args){
        int[] toSort = {34, 43, 24, 67, 82, 67, 44, 22, 99, 1, 22};
        //int[] toSort = {43, 34, 24, 67};
        int[] sorted = sort(toSort, 0, toSort.length -1);
        for(int eachInt : sorted) System.out.println(eachInt);
    }
}
