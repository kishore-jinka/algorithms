package com.algorithms.others.strings;

/**
 * Source: FB Interview Practice
 */
public class RotationalCipher {
    // Add any helper functions you may need here

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        char[] inputChars = input.toCharArray();
        for(int i=0; i<inputChars.length; i++){
            int intChar = inputChars[i];
            if(intChar >= 97 && intChar <= 122){
                intChar = intChar + rotationFactor%26;
                if(intChar > 122) intChar = intChar - 26;
            }else if(intChar >= 65 && intChar <= 90){
                intChar = intChar + rotationFactor%26;
                if(intChar > 90) intChar = intChar - 26;
            }else if(inputChars[i] >= 48 && intChar <= 57){
                intChar = intChar + rotationFactor%10;
                if(intChar > 57) intChar = intChar - 10;
            }
            inputChars[i] = (char) intChar;
        }
        return new String(inputChars);
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        String rightTick = "CORRECT";
        String wrongTick = "WRONG";
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new RotationalCipher().run();
    }
}
