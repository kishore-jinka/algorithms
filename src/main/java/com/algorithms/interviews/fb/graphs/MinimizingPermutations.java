package com.algorithms.interviews.fb.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimizingPermutations {

    // Add any helper functions you may need here
    private int[][] getNeighbors(int[] arr){
        int totalNeighbors = arr.length * (arr.length-1)/2;
        int[][] neighbors = new int[totalNeighbors][arr.length];
        int row = 0;
        for(int start=0; start<arr.length-1; start++){
            for(int end=start+1; end<arr.length; end++){
                neighbors[row] = reverseOrder(arr, start, end);
                row++;
            }
        }
        return neighbors;
    }

    private int[] reverseOrder(int[] arr, int start, int end){
        int[] toReturn = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            toReturn[i] = arr[i];
        }
        for(int i=start; i<end; i++){
            int temp = toReturn[i];
            toReturn[i] = toReturn[end - (i-start)];
            toReturn[end - (i-start)] = temp;
        }
        return toReturn;
    }

    private boolean isSorted(int[] neighbor){
        for(int i=0; i<neighbor.length-1; i++){
            if(neighbor[i] > neighbor[i+1]) return false;
        }
        return true;
    }

    int minOperations(int[] arr) {
        // Write your code here
        if(arr.length < 2) return 0;
        int operations = 0;
        boolean sorted = false;
        Queue<int[]> queue = new LinkedList();
        queue.add(arr);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] node = queue.poll();
                if(isSorted(node)){
                    sorted = true;
                    break;
                }
                int[][] neighbors = getNeighbors(node);
                for(int[] neighbor : neighbors){
                    queue.add(neighbor);
                }
            }
            if(sorted){
                break;
            }
            operations++;
        }
        return operations;
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

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here
    }

    public static void main(String[] args) {
        new MinimizingPermutations().run();
    }
}
