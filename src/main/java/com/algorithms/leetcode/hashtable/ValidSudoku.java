package com.algorithms.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 * https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1126/
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<SudokuKey, Integer> map = new HashMap();
        for(int row=0; row<board.length; row++){
            for(int column=0; column<board[row].length; column++){
                if(board[row][column] != '.') {
                    SudokuKey key = new SudokuKey();
                    key.row = row;
                    key.column = column;
                    key.grid = getGrid(row, column);
                    key.c = board[row][column];
                    if (map.containsKey(key)){
                        return false;
                    }else{
                        map.put(key, 1);
                    }
                }
            }
        }
        return true;
    }

    private int getGrid(int row, int column){
        if(row < 3 & column < 3){
            return 0;
        }else if(row < 3 && column >= 3 && column < 6){
            return 1;   
        }else if(row < 3 && column >= 6 && column < 9){
            return 2;
        }else if(row >= 3 && row < 6 && column < 3){
            return 3;
        }else if(row >= 3 && row < 6 && column >= 3 && column < 6){
            return 4;
        }else if(row >= 3 && row < 6 && column >= 6 && column < 9){
            return 5;
        }else if(row >= 6 && row < 9 && column < 3){
            return 6;
        }else if(row >= 6 && row < 9 && column >= 3 && column < 6){
            return 7;
        }else if(row >= 6 && row < 9 && column >= 6 && column < 9){
            return 8;
        }
        return -1;
    }

    private class SudokuKey{
        int row;
        int column;
        int grid;
        char c;

        public boolean equals(Object obj){
            SudokuKey sk = (SudokuKey) obj;
            if((this.row == sk.row || this.column == sk.column || this.grid == sk.grid) && this.c == sk.c) return true;
            return false;
        }

        public int hashCode(){
            return this.c;
        }
    }
    
    
    public static void main(String[] args){
/*
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}}; */

        char[][] board = {{'8','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};
/*
        char[][] board = {{'.','.','.','.','5','.','.','1','.'},
                        {'.','4','.','3','.','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','1'},
                        {'8','.','.','.','.','.','.','2','.'},
                        {'.','.','2','.','7','.','.','.','.'},
                        {'.','1','5','.','.','.','.','.','.'},
                        {'.','.','.','.','.','2','.','.','.'},
                        {'.','2','.','9','.','.','.','.','.'},
                        {'.','.','4','.','.','.','.','.','.'}}; */

        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(board));
    }
}
