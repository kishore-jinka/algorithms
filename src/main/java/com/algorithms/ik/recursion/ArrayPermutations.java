package com.algorithms.ik.recursion;

public class ArrayPermutations {

    static void printPermutation(int[] intArray, int k, int length){
        if (k == length-1) {
            for(int j=0; j<intArray.length; j++){
                System.out.print(intArray[j]);
            }
            System.out.println();
            return;
        }
        for (int i = k; i < length; i++) {
            swap(intArray, k, i);
            printPermutation(intArray, k+1, length);
            swap(intArray, k, i);
        }
    }

    private static void swap(int[] intArray, int position1, int position2){
        int temp = intArray[position1];
        intArray[position1] = intArray[position2];
        intArray[position2] = temp;
    }

    public static void main(String[] args){
        int[] intArray = {1,2,3};
        printPermutation(intArray, 0, 3);
    }
}
