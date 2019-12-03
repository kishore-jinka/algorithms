package com.algorithms.others.graphs;

//TODO
public class MinimumFlips {
}

/*
Given a binary 2D grid (each element can either be a 1 or a 0).
You have the ability to choose any element and flip its value.
The only condition is that when you choose to flip any element at index (r, c), the 4 neighbors of that element also get flipped.
Find the minimum number of flips that you need to do in order to set all the elements in the matrix equal to 0.
If it's not possible, return -1.

Example 1:

Input:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

Output: 0
Example 2:

Input:
[[0, 1, 0],
 [1, 1, 1],
 [0, 1, 0]]

Output: 1
Explanation: Flip (1, 1) to make the whole matrix consisting of only 0s.
 */