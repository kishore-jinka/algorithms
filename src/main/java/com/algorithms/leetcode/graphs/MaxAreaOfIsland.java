package com.algorithms.leetcode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 695. Max Area of Island
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == 1 && !visited[row][column]){
                    int area = breathFirstSearch(visited, grid, new Coordinates(row, column));
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int breathFirstSearch(boolean[][] visited, int[][] grid, Coordinates coordinates){
        Queue<Coordinates> queue = new LinkedList();
        int area = 0;
        queue.add(coordinates);
        visited[coordinates.row][coordinates.column] = true;
        area++;
        while(!queue.isEmpty()){
            Coordinates next = queue.poll();
            List<Coordinates> neighbors = getNeighbors(grid, next);
            for(Coordinates neighbor : neighbors){
                if(!visited[neighbor.row][neighbor.column]){
                    visited[neighbor.row][neighbor.column] = true;
                    area++;
                    queue.add(neighbor);
                }
            }
        }
        return area;
    }

    private List<Coordinates> getNeighbors(int[][] grid, Coordinates coordinates){
        List<Coordinates> neighbors = new ArrayList<Coordinates>();
        if(coordinates.row-1 >= 0 && grid[coordinates.row-1][coordinates.column] == 1)
            neighbors.add(new Coordinates(coordinates.row-1, coordinates.column));
        if(coordinates.column-1 >= 0 && grid[coordinates.row][coordinates.column-1] == 1)
            neighbors.add(new Coordinates(coordinates.row, coordinates.column-1));
        if(coordinates.row+1 <= grid.length - 1 && grid[coordinates.row+1][coordinates.column] == 1)
            neighbors.add(new Coordinates(coordinates.row+1, coordinates.column));
        if(coordinates.column+1 <= grid[0].length - 1 && grid[coordinates.row][coordinates.column+1] == 1)
            neighbors.add(new Coordinates(coordinates.row, coordinates.column+1));
        return neighbors;
    }

    private class Coordinates {
        int row;
        int column;
        Coordinates(int row, int column){
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args){
        int[][] grid = new int[8][13];

        //[0,0,1,0,0,0,0,1,0,0,0,0,0],
        grid[0][0] = 0;
        grid[0][1] = 0;
        grid[0][2] = 1;
        grid[0][3] = 0;
        grid[0][4] = 0;
        grid[0][5] = 0;
        grid[0][6] = 0;
        grid[0][7] = 1;
        grid[0][8] = 0;
        grid[0][9] = 0;
        grid[0][10] = 0;
        grid[0][11] = 0;
        grid[0][12] = 0;

        //[0,0,0,0,0,0,0,1,1,1,0,0,0],
        grid[1][0] = 0;
        grid[1][1] = 0;
        grid[1][2] = 0;
        grid[1][3] = 0;
        grid[1][4] = 0;
        grid[1][5] = 0;
        grid[1][6] = 0;
        grid[1][7] = 1;
        grid[1][8] = 1;
        grid[1][9] = 1;
        grid[1][10] = 0;
        grid[1][11] = 0;
        grid[1][12] = 0;

        //[0,1,1,0,1,0,0,0,0,0,0,0,0],
        grid[2][0] = 0;
        grid[2][1] = 1;
        grid[2][2] = 1;
        grid[2][3] = 0;
        grid[2][4] = 1;
        grid[2][5] = 0;
        grid[2][6] = 0;
        grid[2][7] = 0;
        grid[2][8] = 0;
        grid[2][9] = 0;
        grid[2][10] = 0;
        grid[2][11] = 0;
        grid[2][12] = 0;

        //[0,1,0,0,1,1,0,0,1,0,1,0,0],
        grid[3][0] = 0;
        grid[3][1] = 1;
        grid[3][2] = 0;
        grid[3][3] = 0;
        grid[3][4] = 1;
        grid[3][5] = 1;
        grid[3][6] = 0;
        grid[3][7] = 0;
        grid[3][8] = 1;
        grid[3][9] = 0;
        grid[3][10] = 1;
        grid[3][11] = 0;
        grid[3][12] = 0;

        //[0,1,0,0,1,1,0,0,1,1,1,0,0],
        grid[4][0] = 0;
        grid[4][1] = 1;
        grid[4][2] = 0;
        grid[4][3] = 0;
        grid[4][4] = 1;
        grid[4][5] = 1;
        grid[4][6] = 0;
        grid[4][7] = 0;
        grid[4][8] = 1;
        grid[4][9] = 1;
        grid[4][10] = 1;
        grid[4][11] = 0;
        grid[4][12] = 0;

        //[0,0,0,0,0,0,0,0,0,0,1,0,0],
        grid[5][0] = 0;
        grid[5][1] = 0;
        grid[5][2] = 0;
        grid[5][3] = 0;
        grid[5][4] = 0;
        grid[5][5] = 0;
        grid[5][6] = 0;
        grid[5][7] = 0;
        grid[5][8] = 0;
        grid[5][9] = 0;
        grid[5][10] = 1;
        grid[5][11] = 0;
        grid[5][12] = 0;

        //[0,0,0,0,0,0,0,1,1,1,0,0,0],
        grid[6][0] = 0;
        grid[6][1] = 0;
        grid[6][2] = 0;
        grid[6][3] = 0;
        grid[6][4] = 0;
        grid[6][5] = 0;
        grid[6][6] = 0;
        grid[6][7] = 1;
        grid[6][8] = 1;
        grid[6][9] = 1;
        grid[6][10] = 0;
        grid[6][11] = 0;
        grid[6][12] = 0;

        // [0,0,0,0,0,0,0,1,1,0,0,0,0]
        grid[7][0] = 0;
        grid[7][1] = 0;
        grid[7][2] = 0;
        grid[7][3] = 0;
        grid[7][4] = 0;
        grid[7][5] = 0;
        grid[7][6] = 0;
        grid[7][7] = 1;
        grid[7][8] = 1;
        grid[7][9] = 0;
        grid[7][10] = 0;
        grid[7][11] = 0;
        grid[7][12] = 0;

        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int maxArea = maxAreaOfIsland.maxAreaOfIsland(grid);
        System.out.println(maxArea);
    }
}



/*
Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
 */
