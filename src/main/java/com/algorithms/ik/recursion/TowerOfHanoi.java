package com.algorithms.ik.recursion;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
    public static List<List<Integer>> tower_of_hanoi(int n) {
        List<List<Integer>> moves = new ArrayList<List<Integer>>();
        makeMoves(n, 1, 3, 2, moves);
        return moves;
    }

    private static void makeMoves(int n, int fromPeg, int toPeg, int auxPeg, List<List<Integer>> moves){
        if(n == 1){
            List<Integer> oneMove = new ArrayList<Integer>(2);
            oneMove.add(fromPeg);
            oneMove.add(toPeg);
            moves.add(oneMove);
            //System.out.println("Move disk 1 from rod " +  fromPeg + " to rod " + toPeg);
            return;
        }else if(n > 1){
            makeMoves(n-1, fromPeg, auxPeg, toPeg, moves);
            List<Integer> oneMove = new ArrayList<Integer>(2);
            oneMove.add(fromPeg);
            oneMove.add(toPeg);
            moves.add(oneMove);
            //System.out.println("Move disk " + n + " from rod " +  fromPeg + " to rod " + toPeg);
            makeMoves(n-1, auxPeg, toPeg, fromPeg, moves);
        }
    }

    public static void main(String[] args){
        int disks = 4;
        List<List<Integer>> moves = tower_of_hanoi(disks);
        for( List l : moves ){
            System.out.println(l.get(0) + ", " + l.get(1));
        }
    }
}

/*
Tower Of Hanoi


Problem Statement:



Tower of Hanoi is a mathematical puzzle where we have three pegs and n disks. The objective of the puzzle is to move the entire stack to another peg, obeying the following simple rules:



Only one disk can be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
No disk may be placed on top of a smaller disk.


Here, we are given n denoting the number of disks in the first peg, we need to return all the steps taken to move all disks from the first peg to the third peg.



There can be multiple possibilities to complete the given objective. Every valid possibility to achieve objective will be a valid answer.



Input/Output Format For The Function:



Input Format:



There is only one argument in the input, an integer named n denoting the number of disks in the first peg.



Output Format:



Return a 2d integer array denoting steps taken to move disks from the first peg to the third peg. Each row will have two integers denoting from peg and to peg, for example, if the ith row is [2, 3], then it means in this step, we moved top disk on peg 2 to peg 3.



For input n = 4, the output will be a 2d array result = [ [1, 2], [1, 3], [2, 3], [1, 2], [3, 1], [3, 2], [1, 2], [1, 3], [2, 3], [2, 1], [3, 1], [2, 3], [1, 2], [1, 3], [2, 3] ]



Input/Output Format For The Custom Input:



Input Format:



There should be one line for input, containing a single integer n, denoting the number of disks in the first peg.



If n = 4 then input should be:



4



Output Format:


There will be a 2d array of integers, where ith row of result 2d array will denote ith step taken to reach the objective. Each row will have two integers denoting from peg and to peg, for example, if the ith row is "2 3" then it means, in this step, we moved top disk on peg 2 to peg 3.



For input n = 4, the output will be as follows:



1 2

1 3

2 3

1 2

3 1

3 2

1 2

1 3

2 3

2 1

3 1

2 3

1 2

1 3

2 3



Constraints:



1 <= n <= 20


Sample Test Case:



Input:



n = 4



Output:



[ [1, 2], [1, 3], [2, 3], [1, 2], [3, 1], [3, 2], [1, 2], [1, 3], [2, 3], [2, 1], [3, 1], [2, 3], [1, 2], [1, 3], [2, 3] ]



Explaination:



Following steps:



[1, 2] = Shift top disk of the first peg to top of the second peg.

Picture after this step will be:

First peg: 2 3 4

Second peg: 1

Third peg: Empty


[1, 3] = Shift top disk of the first peg to top of the third peg.

Picture after this step will be:

First peg: 3 4

Second peg: 1

Third peg: 2



Similarly after following remaining steps will find that the final configuration will be

First peg: Empty

Second peg: Empty

Third peg: 1 2 3 4



which is our objective.
 */