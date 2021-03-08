package com.algorithms.others.strings;

/**
 * Input has brackets (), letters and numbers.
 * Remove unbalanced brackets.
 * Source: FB Interview - Screening Round
 */
public class RemoveUnbalancedBrackets {

    public String removeUnbalancedBrackets(String input){
        char[] chars = input.toCharArray();
        int forwardLeftBrackets = 0;
        int forwardRightBrackets = 0;
        int reverseLeftBrackets = 0;
        int reverseRightBrackets = 0;
        int dashes = 0;
        for(int i=0; i<chars.length; i++){
            char forwardChar = chars[i];
            if(forwardChar == '(') forwardLeftBrackets++;
            if(forwardChar == ')') forwardRightBrackets++;
            if(forwardRightBrackets > forwardLeftBrackets){
                chars[i] = '-';
                dashes++;
                forwardRightBrackets--;
            }

            char reverseChar = chars[chars.length - 1 - i ];
            if(reverseChar == '(') reverseLeftBrackets++;
            if(reverseChar == ')') reverseRightBrackets++;
            if(reverseLeftBrackets > reverseRightBrackets){
                chars[chars.length - 1 - i] = '-';
                dashes++;
                reverseLeftBrackets--;
            }
        }
        char[] finalChars = new char[chars.length - dashes];
        int j=0;
        for(char c : chars){
            if(c != '-'){
                finalChars[j++] = c;
            }
        }
        return new String(finalChars);
    }

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
        String input1 = "a(b)(c";
        String expected_1 = "a(b)c";
        String output_1 = removeUnbalancedBrackets(input1);
        check(expected_1, output_1);

        String input2 = ")(())((()()";
        String expected_2 = "(())()()";
        String output_2 = removeUnbalancedBrackets(input2);
        check(expected_2, output_2);
    }
    public static void main(String[] args) {
        new RemoveUnbalancedBrackets().run();
    }
}
