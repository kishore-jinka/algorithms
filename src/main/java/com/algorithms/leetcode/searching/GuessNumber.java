package com.algorithms.leetcode.searching;

/**
 * 374. Guess Number Higher or Lower
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class GuessNumber extends GuessGame{
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = start + (end - start)/2;
            int guessed = guess(mid);
            if(guessed == 0) return mid;
            if(guessed == 1) start = mid + 1;
            if(guessed == -1) end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        GuessNumber guessNumber = new GuessNumber();
        int guessed = guessNumber.guessNumber(10);
        System.out.println(guessed);
    }
}

class GuessGame{
    private int myNumber = 6;
    int guess(int num){
        if(myNumber > num) return 1;
        if(myNumber < num) return -1;
        return 0;
    }
}

