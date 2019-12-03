package com.algorithms.leetcode.recursion;

public class CalculatePower {
    /*
     * Complete the 'calculate_power' function below.
     *
     * Complete the calculate_power function below.
     *
     * @param a : base
     *
     * @param b : exponent
     */

    public static int calculate_power(long a, long b) {
        // Write your code here
        return (int)(calculate_power_long(a, b)% 1000000007);
    }

    private static long calculate_power_long(long a, long b) {
        // Write your code here
        if(a==0) return 0;
        if(a==1) return 1;
        if(b==0) return 1;
        if(b==1) return a;
        return a*calculate_power(a, b-1);
    }

    public static void main(String[] args){
        System.out.println(calculate_power(2, 10));
    }
}
/*
Power



        Problem Statement:



        The problem statement is straight forward. Given a base ‘a’ and an exponent ‘b’. Your task is to find a^b. The value could be large enough. So, calculate a^b % 1000000007.



        Input/Output Format For The Function:



        Input Format:



        First parameter of the function denotes base a and the second parameter of the function denotes the exponent b.



        Output Format:



        The function returns an integer variable denoting the calculated value of a^b % 1000000007.



        Input/Output Format For The Custom Input:



        Input Format:



        First line of the input contains one single integer a, denoting the value of the base and the second line also contains one single integer denoting the value of the exponent.



        If a = 2 and b = 10, then custom input format will be:



        2

        10



        Output Format:



        Print one single line containing one integer denoting the calculated value of a^b % 1000000007.

        For the above provided custom input, output would be:



        1024



        Constraints:

        0 <= a <= 10^18
        0 <= b <= 10^18
        a and b together can’t be 0


        Sample Test Case:



        a = 2

        b = 10



        Sample Output:



        1024



        Explanation:



        For the above sample input:

        2^10 = 1024, and

        1024 % 1000000007 = 1024

        Hence, output is 1024.
*/