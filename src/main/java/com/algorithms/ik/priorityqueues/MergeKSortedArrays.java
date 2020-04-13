package com.algorithms.ik.priorityqueues;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Similar to LeetCode 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedArrays {

    static int[] mergeArrays(int[][] arr) {
        if(arr.length == 0) return null;
        int totalLength = arr.length * arr[0].length;
        int[] toReturn = new int[totalLength];
        boolean isIncreasing = isIncreasing(arr);
        ListNode[] lists = getLists(arr);
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, new ComparatorImpl(isIncreasing));
        for(ListNode listNode : lists){
            if(listNode != null) priorityQueue.add(listNode);
        }
        int index = 0;
        while(!priorityQueue.isEmpty()){
            ListNode toAttach = priorityQueue.poll();
            toReturn[index++] = toAttach.val;
            if(toAttach.next != null) priorityQueue.add(toAttach.next);
        }
        return toReturn;
    }

    private static boolean isIncreasing(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length-1; j++){
                if(arr[i][j] < arr[i][j+1]) return true;
                if(arr[i][j] > arr[i][j+1]) return false;
            }
        }
        return true;
    }

    private static class ComparatorImpl implements Comparator<ListNode> {
        boolean isIncreasing;
        public int compare(ListNode listNode1, ListNode listNode2) {
            if(!isIncreasing){
                return listNode2.val - listNode1.val;
            }
            return listNode1.val - listNode2.val;
        }
        ComparatorImpl(boolean isIncreasing){
            this.isIncreasing = isIncreasing;
        }
    }

    private static ListNode[] getLists(int[][] arr){
        ListNode[] list = new ListNode[arr.length];
        int outer = 0;
        for(int[] inner : arr){
            if(inner.length != 0) {
                ListNode pointerNode = new ListNode(0);
                ListNode headNode = pointerNode;
                for (int i : inner) {
                    ListNode nextNode = new ListNode(i);
                    pointerNode.next = nextNode;
                    pointerNode = pointerNode.next;
                }
                list[outer++] = headNode.next;
            }
        }
        return list;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        //int[] array0 = {1,4,5};
        //int[] array1 = {1,3,4};
        //int[] array2 = {2,6,7};

//        int[] array0 = {7,6,2};
//        int[] array1 = {4,3,1};
//        int[] array2 = {5,4,1};

        int[] array0 = {8, 8, 8, 8, 8};
        int[] array1 = {8, 8, 8, 8, 8};
        int[] array2 = {7, 8, 8, 8, 8};
        int[] array3 = {8, 8, 8, 8, 8};
        int[] array4 = {8, 8, 8, 8, 8};


        int[][] array = {array0, array1, array2, array3, array4};
        int[] merged = mergeArrays(array);

        for(int i: merged){
            System.out.println(i);
        }
    }
}


/*
Merge_K_sorted_arrays



Problem Statement:



This is a popular facebook problem.

Given K sorted arrays arr, of size N each, merge them into a new array res, such that res is a sorted array.


Assume N is very large compared to K. N may not even be known. The arrays could be just sorted streams, for instance, timestamp streams.



All arrays might be sorted in increasing manner or decreasing manner. Sort all of them in the manner they appear in input.



Note:

Repeats are allowed.
Negative numbers and zeros are allowed.
Assume all arrays are sorted in the same order. Preserve that sort order in output.
It is possible to find out the sort order from at least one of the arrays.


Input/Output Format For The Function:



Input Format:



There is only one argument: 2D Integer array arr.

Here, arr[i][j] denotes value at index j of ith input array, 0-based indexing. So, arr is K * N size array.



Output Format:



Return an integer array res, containing all elements from all individual input arrays combined.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain an integer K. The second line should contain an integer N, denoting size of each input array.

In next K lines, ith line should contain N space separated integers, denoting content of ith array of K input arrays, where jth element in this ith line is nothing but arr[i][j], i.e. value at index j of ith array, 0-based indexing.



If K = 3, N = 4 and arr = [

[1, 3, 5, 7],

           	[2, 4, 6, 8],

           	[0, 9, 10, 11]

], then input should be:



3

4

1 3 5 7

2 4 6 8

0 9 10 11



Output Format:



There will be (N*K) lines of output, where ith line contains an integer res[i], denoting value at index i of res.

Here, res is the result array returned by solution function.



For input K = 3, N = 4 and arr = [

[1, 3, 5, 7],

           	[2, 4, 6, 8],

           	[0, 9, 10, 11]

], output will be:



0

1

2

3

4

5

6

7

8

9

10

11



Constraints:

1 <= N <= 500
1 <= K <= 500
-10^6 <= arr[i][j] <= 10^6, for all valid i,j


Sample Test Case:



Sample Input:



K = 3, N =  4

arr[][] = { {1, 3, 5, 7},

           {2, 4, 6, 8},

           {0, 9, 10, 11}} ;



Sample Output:



[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 */