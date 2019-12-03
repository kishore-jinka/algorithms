package com.algorithms.leetcode.recursion;

import java.util.Arrays;
import java.util.List;

public class ExpressionsEvaluateToSum {

    /*
     * Complete the function below.
     */
    static String[] generate_all_expressions(String s, long target) {
        List<String> possibleExpressions = generatePossibleExpressions(s);
        pruneExpressionsToSumTotal(possibleExpressions);
        String[] stringsToReturn = new String[possibleExpressions.size()];
        for(int i=0; i<possibleExpressions.size(); i++){
            stringsToReturn[i] = possibleExpressions.get(i);
        }
        return stringsToReturn;
    }

    private static List<String> generatePossibleExpressions(String s){
        return null;
    }

    private static void pruneExpressionsToSumTotal(List<String> expressions){

    }

    public static void main(String[] args){
        String s = "222";
        long target = 24;
        System.out.println(Arrays.toString(generate_all_expressions(s, target)));
    }

}

/*
Generate All Possible Expressions That Evaluate To The Given Target Value



Problem Statement:



You are given a string s of length n, containing only numerical characters ('0' - '9'). You are also given a non-negative number target.



You have to put between each pair of numerical characters, one of ("", "*", "+") operators such that the expression you get will evaluate to the target value.

You have to return ALL possible strings(expressions) that evaluate to target value.



Putting "" (an empty string) operator between two numerical characters means, that the they are joined (e.g. 1""2 = 12). Also the join can be extended further (e.g. 1""2""3 = 123).



Precedence of the operators matters. In higher to lower precedence:

Join ("") > Multiplication ("*") > Addition ("+")



The purpose of this problem is to learn recursion and not DP. So, you must write at least one recursive solution. After that, you can write a DP solution if you want.



Input/Output Format For The Function:



Input Format:



There are two arguments.

1) String s.

2) Long integer target.



Output Format:



Return array of strings res, containing ALL possible strings that evaluate to the target value.



You need not to worry about the order of strings in your output array. Like for s = "22" and target = 4, arrays ["2+2", "2*2"] and ["2*2", "2+2"] both will be accepted.



Any string in the returned array should not contain any spaces. In the above example string "2+2" is expected, other strings containing any space like " 2+2", "2 + 2", "2 +2" etc. will give wrong answer.



Input/Output Format For The Custom Input:



Input Format:



The first line of input should contain a string s, denoting input string. The second line should contain an integer target, denoting the target value as explained in problem statement section.



If s = “222” and target = 24, then input should be:



222

24



Output Format:



Let’s denote the size of res as m, where res is the resultant array of strings returned by solution function.

Then, there will be m lines of output, where ith line contains a string res[i], denoting value at index i of res.



For input s = “222” and target = 24, output will be:



2+22

22+2



Constraints:



1 <= n <= 13
s contains only numerical characters ('0' - '9').
0 <= target < 10^13


Sample Test Cases:



Sample Input:



s = "222"

target = 24



Sample Output:



["22+2", "2+22"]



Explanation:



1) 22 + 2 = 24 (Here, we put "" operator between the first two characters and then put "+" operator between the last two characters.)

2) 2 + 22 = 24 (Here, we put "+" operator between the first two characters and then put "" operator between the last two characters.)



Notes:

Suggested time in interview: 40 minutes.

The “Suggested Time” is the time expected to complete this question during a real-life interview, not now in homework i.e. For the first attempt of a given homework problem, the focus should be to understand what the problem is asking, what approach you are using, coding it, as well as identifying any gaps that you can discuss during a TC session. Take your time, but limit yourself to 2 one hour sessions for most problems.
 */