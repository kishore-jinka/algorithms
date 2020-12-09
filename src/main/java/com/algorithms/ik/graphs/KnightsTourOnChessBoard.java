package com.algorithms.ik.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Knight's Tour On A Chess Board
 * https://oj.interviewkickstart.com/view_test_problem/5370/40/
 */
public class KnightsTourOnChessBoard {
    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        if(start_row == end_row && start_col == end_col) return 0;
        Queue<Coordinates> queue = new LinkedList();
        queue.add(new Coordinates(start_row, start_col));
        boolean[][] visited = new boolean[rows][cols];
        visited[start_row][start_col] = true;
        int distance = 0;
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            distance++;
            for(int i=0; i<numberOfNodes; i++) {
                Coordinates next = queue.poll();
                List<Coordinates> neighbors = getNeighbors(rows, cols, next);
                for (Coordinates neighbor : neighbors) {
                    if (!visited[neighbor.row][neighbor.column]) {
                        visited[neighbor.row][neighbor.column] = true;
                        if(neighbor.row == end_row && neighbor.column == end_col) return distance;
                        queue.add(neighbor);
                    }
                }
            }
        }
        return -1;
    }

    private static List<Coordinates> getNeighbors(int rows, int cols, Coordinates coordinates){
        List<Coordinates> neighbors = new ArrayList<Coordinates>();
        if(coordinates.row-2 >= 0 && coordinates.column-1 >= 0)
            neighbors.add(new Coordinates(coordinates.row-2, coordinates.column-1));
        if(coordinates.row-2 >= 0 && coordinates.column+1 <= cols-1)
            neighbors.add(new Coordinates(coordinates.row-2, coordinates.column+1));
        if(coordinates.row+2 <= rows-1 && coordinates.column-1 >= 0)
            neighbors.add(new Coordinates(coordinates.row+2, coordinates.column-1));
        if(coordinates.row+2 <= rows-1 && coordinates.column+1 <= cols-1)
            neighbors.add(new Coordinates(coordinates.row+2, coordinates.column+1));
        if(coordinates.row-1 >= 0 && coordinates.column-2 >= 0)
            neighbors.add(new Coordinates(coordinates.row-1, coordinates.column-2));
        if(coordinates.row-1 >= 0 && coordinates.column+2 <= cols-1)
            neighbors.add(new Coordinates(coordinates.row-1, coordinates.column+2));
        if(coordinates.row+1 <= rows-1 && coordinates.column-2 >= 0)
            neighbors.add(new Coordinates(coordinates.row+1, coordinates.column-2));
        if(coordinates.row+1 <= rows-1 && coordinates.column+2 <= cols-1)
            neighbors.add(new Coordinates(coordinates.row+1, coordinates.column+2));
        return neighbors;
    }

    private static class Coordinates {
        int row;
        int column;
        Coordinates(int row, int column){
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args){
        System.out.println(find_minimum_number_of_moves(5,5,0,0,4,1));
    }
}
