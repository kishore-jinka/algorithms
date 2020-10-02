package com.algorithms.leetcode.graphs;

import java.util.*;

/**
 * 909. Snakes and Ladders
 * https://leetcode.com/problems/snakes-and-ladders/
 * TODO: INCOMPLETE - 201 / 211 test cases passed.
 */
public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int[] realBoard = new int[board.length * board[0].length];
        for(int row = 0; row < board.length; row++){
            int realRow = board.length - 1 - row;
            for(int column = 0; column < board[0].length; column++){
                int realColumn = column;
                if(row % 2 == 1) realColumn = board[0].length - 1 - column;
                int index = row * board[0].length + column;
                realBoard[index] = board[realRow][realColumn];
            }
        }
        int[][] grid = new int[realBoard.length][7];
        for(int i=0; i<realBoard.length - 1; i++){
            if (i + 6 <= realBoard.length - 1) grid[i][6] = realBoard[i + 6] == -1 ? i + 7 : realBoard[i + 6] == i+1 ? 0 : realBoard[i+6];
            if (i + 5 <= realBoard.length - 1) grid[i][5] = realBoard[i + 5] == -1 ? i + 6 : realBoard[i + 5] == i+1 ? 0 : realBoard[i+5];
            if (i + 4 <= realBoard.length - 1) grid[i][4] = realBoard[i + 4] == -1 ? i + 5 : realBoard[i + 4] == i+1 ? 0 : realBoard[i+4];
            if (i + 3 <= realBoard.length - 1) grid[i][3] = realBoard[i + 3] == -1 ? i + 4 : realBoard[i + 3] == i+1 ? 0 : realBoard[i+3];
            if (i + 2 <= realBoard.length - 1) grid[i][2] = realBoard[i + 2] == -1 ? i + 3 : realBoard[i + 2] == i+1 ? 0 : realBoard[i+2];
            if (i + 1 <= realBoard.length - 1) grid[i][1] = realBoard[i + 1] == -1 ? i + 2 : realBoard[i + 1] == i+1 ? 0 : realBoard[i+1];
            if (i <= realBoard.length - 1) grid[i][0] = realBoard[i] == -1 ? i + 1 : realBoard[i] == i+1 ? 0 : realBoard[i];
        }
        boolean[] visited = new boolean[realBoard.length];
        return breathFirstSearch(visited, grid, 1);
    }

    public int breathFirstSearch(boolean[] visited, int[][] graph, int start){
        Queue<Integer> queue = new LinkedList();
        int minimumThrows = 0;
        queue.add(start);
        visited[start - 1] = true;
        while(!queue.isEmpty()){
            int numberOfNodes = queue.size();
            boolean endNodeVisited = false;
            for(int i=0; i<numberOfNodes; i++){
                Integer node = queue.poll();
                int[] childNodes = graph[node - 1];
                for(int childNode : childNodes){
                    if(childNode != 0 && !visited[childNode - 1]){
                        if(childNode == visited.length){
                            endNodeVisited = true;
                        }
                        queue.add(childNode);
                        visited[childNode - 1] = true;
                    }
                }
            }
            minimumThrows++;
            if(endNodeVisited) break;
        }
        return minimumThrows;
    }

    public static void main(String[] args){
        int[][] board = {{-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};
        SnakesAndLadders sAndL = new SnakesAndLadders();
        System.out.println(sAndL.snakesAndLadders(board));
    }
}
