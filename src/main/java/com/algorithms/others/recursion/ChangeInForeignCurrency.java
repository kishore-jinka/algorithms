package com.algorithms.others.recursion;

/**
 * Source: FB Interview Practice
 */
public class ChangeInForeignCurrency {

    // Add any helper functions you may need here
    boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        if(targetMoney == 0) return true;
        for(int i=denominations.length-1; i>0; i--){
            if(targetMoney >= denominations[i]){
                return canGetExactChange(targetMoney - denominations[i], denominations);
            }
        }
        return false;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        String rightTick = "CORRECT";
        String wrongTick = "WRONG";
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
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        int target_1 = 94;
        int arr_1[] = {5, 10, 25, 100, 200};
        boolean expected_1 = false;
        boolean output_1 = canGetExactChange(target_1, arr_1);
        check(expected_1, output_1);

        int target_2 = 75;
        int arr_2[] = {4, 17, 29};
        boolean expected_2 = true;
        boolean output_2 = canGetExactChange(target_2, arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ChangeInForeignCurrency().run();
    }
}
