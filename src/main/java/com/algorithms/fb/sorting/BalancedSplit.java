package com.algorithms.fb.sorting;

import java.util.Arrays;

public class BalancedSplit {
    // Add any helper functions you may need here


    boolean balancedSplitExists(int[] arr) {
        // Write your code here
        int sum=0;
        for(int value : arr) sum = sum+value;
        if(sum%2 == 1) return false;
        Arrays.sort(arr);
        sum = sum/2;
        int total = 0;
        for(int i=0; i<arr.length-1; i++){
            total = total + arr[i];
            if(total == sum){
                if(arr[i] < arr[i+1]){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        int arr_1[] = {2, 1, 2, 5};
        boolean expected_1 = true;
        boolean output_1 = balancedSplitExists(arr_1);
        check(expected_1, output_1);

        int arr_2[] = {3, 6, 3, 4, 4};
        boolean expected_2 = false;
        boolean output_2 = balancedSplitExists(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BalancedSplit().run();
    }
}
