package com.algorithms.sorting;

public class MergeFirstAndSecondSortedArrays {


    static int[] merger_first_into_second(int[] arr1, int[] arr2) {
        int toShiftTo = arr2.length/2;
        for(int i=0; i<toShiftTo; i++){
            arr2[toShiftTo+i] = arr2[i];
            arr2[i] = 0;
        }
        int i=0;
        int j=0;
        int k=toShiftTo;
        while(j<arr1.length){

            if(k >= arr2.length || arr1[j] <= arr2[k] ){
                arr2[i] = arr1[j];
                i++;
                j++;
            }else{
                arr2[i] = arr2[k];
                arr2[k] = 0;
                i++;
                k++;
            }

        }
        return arr2;
    }



    public static void main(String[] args){
        //Test Case 1
        //int[] arr1 = {1, 3, 5};
        //int[] arr2 = {2, 4, 6, 0, 0, 0};
        int[] arr1 = {13, 21};
        int[] arr2 = {13, 13, 0, 0};
        //int[] arr1 = {4, 5, 6};
        //int[] arr2 = {1, 2, 3, 0, 0, 0};
        int[] arr = merger_first_into_second(arr1, arr2);
        printArray(arr);
    }


    private static void printArray(int[] arr){
        for(int i: arr){
            System.out.println(i);
        }
    }
}
