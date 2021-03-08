package com.algorithms.others.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Source: FB Interview Practice
 */
public class QueueRemovals {
    // Add any helper functions you may need here
    int[] findPositions(int[] arr, int x) {
        // Write your code here
        Queue<Integer> positionsQueue = new LinkedList();
        for(int i=0; i<arr.length; i++) positionsQueue.add(i+1);
        int[] indices = new int[x];
        int itr = 0;
        Queue<Integer> firstQueue = new LinkedList();
        Queue<Integer> standByQueue = new LinkedList();
        for(int i : arr) firstQueue.add(i);
        for(int cycle=0; cycle<x; cycle++){
            int maxIndex= -1;
            int maxValue= -1;
            int size = x;
            if(firstQueue.size() < x) size = firstQueue.size();
            for(int i=0; i<size; i++){
                int value = firstQueue.poll();
                standByQueue.add(value);
                if(value > maxValue){
                    maxIndex = i;
                    maxValue = value;
                }
            }
            for(int i=0; i<size; i++){
                int position = positionsQueue.poll();
                int standByValue = standByQueue.poll();
                if(i == maxIndex){
                    indices[itr] = position;
                    itr++;
                }else{
                    positionsQueue.add(position);
                    if(standByValue > 0){
                        firstQueue.add(standByValue - 1);
                    }else{
                        firstQueue.add(0);
                    }
                }
            }
        }
        return indices;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        String rightTick = "CORRECT";
        String wrongTick = "WRONG";
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);
        check(expected_1, output_1);

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions(arr_2, x_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new QueueRemovals().run();
    }
}
