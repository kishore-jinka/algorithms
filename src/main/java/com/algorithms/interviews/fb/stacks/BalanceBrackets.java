package com.algorithms.interviews.fb.stacks;

import java.util.Stack;

public class BalanceBrackets {
    boolean isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c == '[' || c == '{' || c == '('){
                stack.add(c);
            }else if(c == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                }else return false;
            }else if(c == '}'){
                if(stack.peek() == '{'){
                    stack.pop();
                }else return false;
            }else if(c == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                }else return false;
            }else return false;
        }
        return true;
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
        System.out.print("[" + str + "]");
    }

    public void run() {
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        check(expected_1, output_1);

        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        boolean output_2 = isBalanced(s_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BalanceBrackets().run();
    }
}
