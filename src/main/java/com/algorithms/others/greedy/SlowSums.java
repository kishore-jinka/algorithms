package com.algorithms.others.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Source: FB Interview Practice
 */
public class SlowSums {
    // Add any helper functions you may need here
    int getTotalTime(int[] arr) {
        // Write your code here
        if(arr.length == 1) return arr[0];
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return -1;
                }else if(o1 < o2){
                    return 1;
                }
                return 0;
            }
        });
        for(int element : arr){
            maxPriorityQueue.add(element);
        }
        int[] totals = new int[arr.length];
        totals[0] = maxPriorityQueue.poll();
        int i=1;
        int sum = 0;
        while(!maxPriorityQueue.isEmpty()){
            totals[i] = totals[i-1] + maxPriorityQueue.poll();
            sum = sum + totals[i];
            i++;
        }
        return sum;
    }












    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        String rightTick = "CORRECT";
        String wrongTick = "WRONG";
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() {
        int[] arr_1 = {4, 2, 1, 3};
        int expected_1 = 26;
        int output_1 = getTotalTime(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 3, 9, 8, 4};
        int expected_2 = 88;
        int output_2 = getTotalTime(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new SlowSums().run();
    }
}
