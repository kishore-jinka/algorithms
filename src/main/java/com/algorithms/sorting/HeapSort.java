package com.algorithms.sorting;

public class HeapSort {
    private static void percolateDownHeapify(int[] toSort, int finalIndex, int indexToSort){
        int leftChildIndex = 2*indexToSort + 1;
        int rightChildIndex = leftChildIndex + 1;
        int greatestValueIndex = indexToSort;
        if(leftChildIndex < finalIndex && toSort[leftChildIndex] > toSort[greatestValueIndex]){
            greatestValueIndex = leftChildIndex;
        }
        if(rightChildIndex < finalIndex && toSort[rightChildIndex] > toSort[greatestValueIndex]){
            greatestValueIndex = rightChildIndex;
        }
        if(greatestValueIndex != indexToSort){
            swapAtIndices(toSort, indexToSort, greatestValueIndex);
            percolateDownHeapify(toSort, finalIndex, greatestValueIndex);
        }
    }

    private static void swapAtIndices(int[] toSort, int swapFrom, int swapTo){
        if(swapFrom == swapTo) return;
        int temp = toSort[swapTo];
        toSort[swapTo] = toSort[swapFrom];
        toSort[swapFrom] = temp;
    }

    private static void doHeapSort(int[] toSort){
        for(int i = toSort.length/2 - 1; i>=0; i--){
            percolateDownHeapify(toSort, toSort.length - 1, i);
        }
        for(int i = toSort.length - 1; i>0; i--){
            swapAtIndices(toSort, i, 0);
            percolateDownHeapify(toSort, i-1, 0);
        }
    }

    public static void main(String[] args){
        int[] toSort = {34, 43, 24, 67, 82, 67, 44, 22, 99, 1, 22};
        //int[] toSort = {43, 34, 24, 67};
        doHeapSort(toSort);
        for(int eachInt : toSort) System.out.println(eachInt);
    }
}
