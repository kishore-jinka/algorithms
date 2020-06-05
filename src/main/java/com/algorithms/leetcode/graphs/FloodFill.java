package com.algorithms.leetcode.graphs;

import java.util.*;

/**
 * 733. Flood Fill
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(sr < 0 || sc < 0 || sr > image.length-1 || sc > image[0].length-1) return image;
        if(image[sr][sc] == newColor) return image;
        breathFirstSearch(image, new Coordinates(sr, sc), image[sr][sc], newColor);
        return image;
    }

    public void breathFirstSearch(int[][] image, Coordinates coordinates, int currentColor, int newColor){
        Queue<Coordinates> queue = new LinkedList();
        queue.add(coordinates);
        image[coordinates.row][coordinates.column] = newColor;
        while(!queue.isEmpty()){
            Coordinates next = queue.poll();
            List<Coordinates> neighbors = getNeighbors(image, next, currentColor);
            for(Coordinates neighbor : neighbors){
                if(image[neighbor.row][neighbor.column] != newColor){
                    image[neighbor.row][neighbor.column] = newColor;
                    queue.add(neighbor);
                }
            }
        }
    }

    private List<Coordinates> getNeighbors(int[][] image, Coordinates coordinates, int currentColor){
        List<Coordinates> neighbors = new ArrayList<Coordinates>();
        if(coordinates.row-1 >= 0 && image[coordinates.row-1][coordinates.column] == currentColor)
            neighbors.add(new Coordinates(coordinates.row-1, coordinates.column));
        if(coordinates.column-1 >= 0 && image[coordinates.row][coordinates.column-1] == currentColor)
            neighbors.add(new Coordinates(coordinates.row, coordinates.column-1));
        if(coordinates.row+1 <= image.length - 1 && image[coordinates.row+1][coordinates.column] == currentColor)
            neighbors.add(new Coordinates(coordinates.row+1, coordinates.column));
        if(coordinates.column+1 <= image[0].length - 1 && image[coordinates.row][coordinates.column+1] == currentColor)
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
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;
        grid[2][0] = 1;
        grid[2][1] = 0;
        grid[2][2] = 1;
        FloodFill floodFill = new FloodFill();
        int[][] fill = floodFill.floodFill(grid, 1, 1, 2);
        for(int row = 0; row < fill.length; row++){
            System.out.println(Arrays.toString(fill[row]));
        }
    }
}