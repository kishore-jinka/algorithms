package com.algorithms.sorting;

public class GroupEvenOdd {
    /*
     * Complete the function below.
     */
    static int[] solve(int[] arr) {
        int i=0;
        int j=arr.length -1;
        while(i<j){
            if(arr[i]%2 == 0 && arr[j]%2 == 1){
                i++;
                j--;
            }else if(arr[i]%2 == 1 && arr[j]%2 == 0){
                swapAtIndices(arr, i, j);
                i++;
                j--;
            }else if(arr[i]%2 == 0 && arr[j]%2 == 0){
                i++;
            }else if(arr[i]%2 == 1 && arr[j]%2 == 1){
                j--;
            }
        }
        return arr;
    }

    private static void swapAtIndices(int[] array, int swapFrom, int swapTo){
        if(swapFrom == swapTo) return;
        int temp = array[swapTo];
        array[swapTo] = array[swapFrom];
        array[swapFrom] = temp;
    }

    private static void printArray(int[] arr){
        for(int i: arr){
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        //Test Case 1
        //int[] arr = {1, 2, 3, 4};
        int[] arr = {90};
        printArray(solve(arr));
    }



}

/*
Group the numbers



Problem Statement:



You are given an integer array arr, of size n. Group and rearrange them (in-place) into evens and odds in such a way that group of all even integers appears on the left side and group of all odd integers appears on the right side.



Input/Output Format For The Function:



Input Format:



There is only one argument: Integer array arr.



Output Format:



Return the same integer array, with evens on left side and odds on the right side.

There is no need to preserve order within odds or within evens.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain an integer n, denoting size of input array arr. In next n lines, ith line should contain an integer arr[i], denoting a value at index i of arr.



If n = 4 and arr = [1, 2, 3, 4], then input should be:



4

1

2

3

4



Output Format:



There will be n lines of output, where ith line contains an integer res[i], denoting value at index i of res.

Here, res is the result array returned by solution function.



For input n = 4 and arr = [1, 2, 3, 4], output will be:



4

2

1

3



Constraints:

1 <= n <= 10^5
arr contains only positive integers.
arr may contains duplicate numbers.
Solution with linear time complexity and constant auxiliary space is expected.


Sample Test Case:



Sample Input:



[1, 2, 3, 4]



Sample Output:



[4, 2, 1, 3]



Explanation:



Order does not matter. Other valid solution are

[2, 4, 1, 3]

[2, 4, 3, 1]

[4, 2, 3, 1]
 */
