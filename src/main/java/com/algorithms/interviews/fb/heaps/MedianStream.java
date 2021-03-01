package com.algorithms.interviews.fb.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianStream {
    // Add any helper functions you may need here
    int[] findMedian(int[] arr) {
        // Write your code here
        PriorityQueue<Integer> minPQueue = new PriorityQueue(); //holds right half
        PriorityQueue<Integer> maxPQueue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return -1;
                }else if(o1 < o2){
                    return 1;
                }
                return 0;
            }
        }); //holds left half
        int[] medians = new int[arr.length];
        medians[0] = arr[0];
        if(medians.length == 1) return medians;
        if(arr[1] > arr[0]){
            minPQueue.add(arr[1]);
            maxPQueue.add(arr[0]);
        }else{
            minPQueue.add(arr[0]);
            maxPQueue.add(arr[1]);
        }
        medians[1] = (maxPQueue.peek() + minPQueue.peek()) / 2;
        for(int i=2; i<arr.length; i++){
            if(maxPQueue.size() > minPQueue.size()){
                if(arr[i] <= maxPQueue.peek()){
                    maxPQueue.add(arr[i]);
                    minPQueue.add(maxPQueue.poll());
                }else{
                    minPQueue.add(arr[i]);
                }
                medians[i] = (maxPQueue.peek() + minPQueue.peek())/2;
            }else if(maxPQueue.size() < minPQueue.size()){
                if(arr[i] <= maxPQueue.peek()){
                    maxPQueue.add(arr[i]);
                }else{
                    minPQueue.add(arr[i]);
                    maxPQueue.add(minPQueue.poll());
                }
                medians[i] = (maxPQueue.peek() + minPQueue.peek())/2;
            }else{
                if(arr[i] <= maxPQueue.peek()){
                    maxPQueue.add(arr[i]);
                    medians[i] = maxPQueue.peek();
                }else{
                    minPQueue.add(arr[i]);
                    medians[i] = minPQueue.peek();
                }
            }
        }
        return medians;
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
        int[] arr_1 = {5, 15, 1, 3};
        int[] expected_1 = {5, 10, 5, 4};
        int[] output_1 = findMedian(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {2, 3, 4, 3, 4, 3};
        int[] output_2 = findMedian(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new MedianStream().run();
    }
}
