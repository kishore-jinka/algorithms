package com.algorithms.leetcode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == '1' && !visited[row][column]){
                    breathFirstSearch(visited, grid, new Coordinates(row, column));
                    islands++;
                }
            }
        }
        return islands;
    }

    public void breathFirstSearch(boolean[][] visited, char[][] grid, Coordinates coordinates){
        Queue<Coordinates> queue = new LinkedList();
        queue.add(coordinates);
        visited[coordinates.row][coordinates.column] = true;
        while(!queue.isEmpty()){
            Coordinates next = queue.poll();
            List<Coordinates> neighbors = getNeighbors(grid, next);
            for(Coordinates neighbor : neighbors){
                if(!visited[neighbor.row][neighbor.column]){
                    visited[neighbor.row][neighbor.column] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    private List<Coordinates> getNeighbors(char[][] grid, Coordinates coordinates){
        List<Coordinates> neighbors = new ArrayList<Coordinates>();
        if(coordinates.row-1 >= 0 && grid[coordinates.row-1][coordinates.column] == '1')
            neighbors.add(new Coordinates(coordinates.row-1, coordinates.column));
        if(coordinates.column-1 >= 0 && grid[coordinates.row][coordinates.column-1] == '1')
            neighbors.add(new Coordinates(coordinates.row, coordinates.column-1));
        if(coordinates.row+1 <= grid.length - 1 && grid[coordinates.row+1][coordinates.column] == '1')
            neighbors.add(new Coordinates(coordinates.row+1, coordinates.column));
        if(coordinates.column+1 <= grid[0].length - 1 && grid[coordinates.row][coordinates.column+1] == '1')
            neighbors.add(new Coordinates(coordinates.row, coordinates.column+1));
        return neighbors;
    }

    class Coordinates {
        int row;
        int column;
        Coordinates(int row, int column){
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args){
//        char[][] grid = new char[4][5];
//        grid[0][0] = '1';
//        grid[0][1] = '1';
//        grid[0][2] = '1';
//        grid[0][3] = '1';
//        grid[0][4] = '0';
//        grid[1][0] = '1';
//        grid[1][1] = '1';
//        grid[1][2] = '0';
//        grid[1][3] = '1';
//        grid[1][4] = '0';
//        grid[2][0] = '1';
//        grid[2][1] = '1';
//        grid[2][2] = '0';
//        grid[2][3] = '0';
//        grid[2][4] = '0';
//        grid[3][0] = '0';
//        grid[3][1] = '0';
//        grid[3][2] = '0';
//        grid[3][3] = '0';
//        grid[3][4] = '0';

        char[][] grid = new char[4][5];
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '0';
        grid[0][3] = '0';
        grid[0][4] = '0';
        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][2] = '0';
        grid[1][3] = '0';
        grid[1][4] = '0';
        grid[2][0] = '0';
        grid[2][1] = '0';
        grid[2][2] = '1';
        grid[2][3] = '0';
        grid[2][4] = '0';
        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '1';
        grid[3][4] = '1';
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int islands = numberOfIslands.numIslands(grid);
        System.out.println(islands);
    }

}


/*

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

 */