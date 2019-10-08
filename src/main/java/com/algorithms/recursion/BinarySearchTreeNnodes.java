package com.algorithms.recursion;

public class BinarySearchTreeNnodes {

    /*
     * Complete the function below.
     */
    static long how_many_BSTs(int n) {
        if (n <= 1) return 1;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            long leftSubTrees = how_many_BSTs(i - 1);
            long rightSubTrees = how_many_BSTs(n - i);
            sum = sum + leftSubTrees * rightSubTrees;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(how_many_BSTs(3));
        //System.out.println(how_many_BSTs(4));
        //System.out.println(how_many_BSTs(5));
    }
}
/*
How Many Binary Search Trees With n Nodes?



Problem Statement:



Write a function that will return the number of binary search trees that can be constructed with n nodes.



There may be other iterative solutions, but for the purpose of this exercise, please use recursive solution.



The purpose of this problem is to learn recursion and not DP. So, you must write at least one recursive solution. After that, you can write a DP solution if you want.



Input/Output Format For The Function:



Input Format:



There is only one argument denoting integer n.



Output Format:



Return number of binary search trees that can be constructed, with n nodes.



Input/Output Format For The Custom Input:



Input Format:



The first and only line of input should contain an integer n.



If n = 3, then input should be:



3



Output Format:



There will be one line, containing an integer res, denoting the result returned by solution function.



For input n = 3, output will be:



5



Constraints:

1 <= n <= 16


Sample Test Cases:



Sample Test Case 1:



Sample Input 1:



1



Sample Output 1:



1



Explanation 1:



1) root (node val = 1)



Sample Test Case 2:



Sample Input 2:



2



Sample Output 2:



2



Explanation 2:



1) root (node val = 2), root->left (node val = 1)

2) root (node val = 1), root->right (node val = 2)



Sample Test Case 3:



Sample Input 3:



3



Sample Output 3:



5



Explanation 3:



1) root (node val = 3), root->left (node val = 2), root->left->left (node val = 1)

2) root (node val = 3), root->left (node val = 1), root->left->right (node val = 2)

3) root (node val = 1), root->right (node val = 2), root->right->right (node val = 3)

4) root (node val = 1), root->right (node val = 3), root->right->left (node val = 2)

5) root (node val = 2), root->left (node val = 1), root->right (node val = 3)



If you keep doing this, it will form a series called Catalan numbers. One can simply lookup the formula for Catalan numbers and write code for it. But that's not how we want to do this. We want to do this by understanding the underlying recursion. The recursion is based on tree-topology only, as you can see by examples above, contents of the nodes of the tree do not matter.
 */
