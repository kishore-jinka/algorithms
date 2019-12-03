package com.algorithms.ik.sorting;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TopKElements {
    /*
     * Complete the function below.
     */
    static int[] topK(int[] arr, int k) {
        SortedSet<Integer> set = new TreeSet<Integer>();
        for(int i: arr){
            if (set.size() < k){
                set.add(i);
            } else if (set.size() == k){
                if(set.first() < i) set.add(i);
                if(set.size() == k+1) set.remove(set.first());
            }
        }
        int[] intArray = new int[set.size()];
        int i=0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            intArray[i++] = iterator.next();
        }
        return intArray;
    }


    private static void printArray(int[] arr){
        for(int i: arr){
            System.out.println(i);
        }
    }

    public static void main(String[] args){
//        int[] arr = {1, 5, 4, 4, 2}; //K = 2
//        printArray(topK(arr, 2));
//        int[] arr2 = {1, 5, 1, 5, 1}; //K = 3
//
//        printArray(topK(arr2, 3));
        //int[] arr3 = {4, 8, 9, 6, 6, 2, 10, 2, 8, 1, 2};
        int[] arr3 = {4, 1, 8, 1, 9, 10, 3, 9, 4, 4, 2, 5, 7, 1, 3, 5};
        printArray(topK(arr3, 8));
    }
}

/*
Top K



Problem Statement:



You are given an array of integers arr, of size n, which is analogous to a continuous stream of integers input. Your task is to find K largest elements from a given stream of numbers.

By definition, we don't know the size of the input stream. Hence, produce K largest elements seen so far, at any given time. For repeated numbers, return them only once.



If there are less than K distinct elements in arr, return all of them.



Note:

Don't rely on size of input array arr.
Feel free to use built-in functions if you need a specific data-structure.


Input/Output Format For The Function:



Input Format:



There is only one argument: Integer array arr.



Output Format:



Return an integer array res, containing K largest elements. If there are less than K unique elements, return all of them.

Order of elements in res does not matter.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain an integer n, denoting size of input array arr. In next n lines, ith line should contain an integer arr[i], denoting a value at index i of arr.

In the next line, there should be an integer, denoting value of K.



If n = 5, arr = [1, 5, 4, 4, 2] and K = 2, then input should be:



5

1

5

4

4

2

2



Output Format:



Let’s denote size of res as m, where res is the array of integers returned by solution function.

Then, there will be m lines of output, where ith line contains an integer res[i], denoting value at index i of res.



For input n = 5, arr = [1, 5, 4, 4, 2] and K = 2, output will be:



4

5



Constraints:

1 <= n <= 10^5
1 <= K <= 10^5
arr may contains duplicate numbers.
arr may or may not be sorted


Sample Test Case:



Sample Test Case 1:



Sample Input 1:



arr = [1, 5, 4, 4, 2]; K = 2



Sample Output 1:



[4, 5]



Sample Test Case 2:



Sample Input 2:



arr = [1, 5, 1, 5, 1]; K = 3



Sample Output 2:



[5, 1]
 */