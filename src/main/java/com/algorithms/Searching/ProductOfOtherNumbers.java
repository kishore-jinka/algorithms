package com.algorithms.Searching;

import java.util.Arrays;

/*
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */
public class ProductOfOtherNumbers {

    public static Integer[] getProductOfOtherNumbers(Integer[] array){
        Integer[] forwardProduct = new Integer[array.length];
        Integer[] reverseProduct = new Integer[array.length];
        Integer[] othersProduct = new Integer[array.length];
        for(int i=0; i<array.length; i++){
            //forwardProduct[i] =
        }

        return null;
    }

    public static void main(String[] args){
        Integer[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(getProductOfOtherNumbers(array)));
    }
}
