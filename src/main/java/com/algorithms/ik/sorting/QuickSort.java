package com.algorithms.ik.sorting;

//arr[] = {10, 80, 30, 90, 40, 50, 70}
public class QuickSort {
    private static int createPartition(int[] toSort, int startIndex, int endIndex){
        int partitionNumber = toSort[endIndex];
        int partitionIndex = endIndex;
        int i = startIndex, j = endIndex - 1;
        //34, 43, 24, 67, 82, 67, 44, 22, 99, 1, 22
        while(i<j){
            System.out.println(i + "," + j);
            if(toSort[i] > partitionNumber && toSort[j] <= partitionNumber){
                swapAtIndices(toSort, i, j);
                i++;
                j--;
            }else if(toSort[i] > partitionNumber && toSort[j] > partitionNumber){
                j--;
            }else if(toSort[i] <= partitionNumber && toSort[j] <= partitionNumber){
                i++;
            }else if(toSort[i] <= partitionNumber && toSort[j] > partitionNumber){
                i++;
                j--;
            }

        }
        if(toSort[j] > partitionNumber) {
            swapAtIndices(toSort, j, partitionIndex);
            return j;
        }else{
            return partitionIndex;
        }
    }

    private static void swapAtIndices(int[] toSort, int swapFrom, int swapTo){
        if(swapFrom == swapTo) return;
        int temp = toSort[swapTo];
        toSort[swapTo] = toSort[swapFrom];
        toSort[swapFrom] = temp;
    }

    private static void doQuickSort(int[] toSort, int startIndex, int endIndex){
        if(startIndex < endIndex) {
            int partitionIndex = createPartition(toSort, startIndex, endIndex);
            doQuickSort(toSort, startIndex, partitionIndex - 1);
            doQuickSort(toSort, partitionIndex + 1, endIndex);
        }
    }

    public static void main(String[] args){
        int[] toSort = {34, 43, 24, 67, 82, 67, 44, 22, 99, 1, 22};
        //int[] toSort = {43, 34, 24, 67};
        doQuickSort(toSort, 0, toSort.length -1);
        for(int eachInt : toSort) System.out.println(eachInt);
    }
}
