package com.algorithms.ik.dynamicprogramming;

public class KnightsTour {
    /*
     * Complete the numPhoneNumbers function below.
     */
    static long numPhoneNumbers(int startdigit, int phonenumberlength) {
        /*
         * Write your code here.
         */

        if(startdigit == 5){
            if(phonenumberlength == 1) return 1;
            return 0;
        }
        long[][] dp = new long[phonenumberlength][10];
        dp[0][startdigit] = 1;
        for(int level=1; level<phonenumberlength; level++){
            for(int key=0; key<10; key++) {
                if (key == 5) continue;
                for (int from : getFromDigits(key)) {
                    dp[level][key] += dp[level-1][from];
                }
            }
        }

        long total = 0;
        for(int key=0; key<10; key++){
            total += dp[phonenumberlength - 1][key];
        }
        return total;
    }

    /**
     * 1 can be reached from 6 or 8
     * 9 can be reached from 2 or 4
     * 0 can be reached from 4 or 6
     * Extend the logic to other numbers on dial pad.
     */
    private static int[] getFromDigits(int i){
        if(i==1){
            return new int[]{6,8};
        }else if(i==2){
            return new int[]{7,9};
        }else if(i==3){
            return new int[]{4,8};
        }else if(i==4){
            return new int[]{3,9,0};
        }else if(i==6){
            return new int[]{1,7,0};
        }else if(i==7){
            return new int[]{2,6};
        }else if(i==8){
            return new int[]{1,3};
        }else if(i==9){
            return new int[]{2,4};
        }else if(i==0){
            return new int[]{4,6};
        }
        else return null;
    }

    public static void main(String[] args){
        System.out.println(numPhoneNumbers(2, 30));
    }
}

/*
Knight's tour!



Problem Statement:



Given a phone keypad as shown below:



1 2 3

4 5 6

7 8 9

- 0 -



How many different phone numbers of given length can be formed starting from the given digit? The constraint is that the movement from one digit to the next is similar to the movement of the Knight in a chess game.



For eg. if we are at 1 then the next digit can be either 6 or 8 if we are at 6 then the next digit can be 1, 7 or 0.



Repetition of digits are allowed - 1616161616 is a valid number.

The problem requires us to just give the count of different phone numbers and not necessarily list the numbers.

Find a polynomial-time solution, based on Dynamic Programming.



Input/Output Format For The Function:



Input Format:



You will be given 2 integer values, startdigit and phonenumberlength, denoting starting digit and the required length respectively.



Output Format:



Return a long integer count, denoting the total number of valid phone numbers that can be formed.



Input/Output Format For The Custom Input:



Input Format:



The first line should contain an integer startdigit, denoting the digit from which the phone number should start. The second line should contain phonenumberlength, denoting the length of phone number to be formed.



If startdigit = 1 and phonenumberlength = 3, then input should be:



1

3



Output Format:



There will be one line, containing an integer count, denoting result returned by the solution function.



For input startdigit = 1 and phonenumberlength = 3, output will be:



5



Constraints:

0 <= startdigit <= 9
1 <=  phonenumberlength <= 30


Sample Test Cases:



Sample Test Case 1:



Sample Input 1:



startdigit = 1

phonenumberlength = 2



Sample Output 1:



2



Explanation 1:



Two possible numbers of length 2: 16, 18



Sample Test Case 2:



Sample Input 2:



startdigit = 1

phonenumberlength = 3



Sample Output 2:



5



Explanation-2:



Possible numbers of length 3: 160, 161, 167, 181, 183
 */
