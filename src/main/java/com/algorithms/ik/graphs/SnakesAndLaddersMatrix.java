package com.algorithms.ik.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Snakes and Ladders Matrix
 * https://oj.interviewkickstart.com/view_test_problem/6556/120/
 * TODO INCOMPLETE: 19 / 30 test cases passed successfully.
 *
 * Same as 909. Snakes and Ladders
 * https://leetcode.com/problems/snakes-and-ladders/
 *
 */
public class SnakesAndLaddersMatrix {

    static int minNumberOfRolls(int n, List<Integer> moves) {
        int[][] grid = new int[n][7];
        for(int i=0; i<n; i++){
            if (i + 6 <= n - 1) grid[i][6] = moves.get(i+6) == -1 ? i + 7 : moves.get(i+6) == i+1 ? 0 : moves.get(i+6);
            if (i + 5 <= n - 1) grid[i][5] = moves.get(i+5) == -1 ? i + 6 : moves.get(i+5) == i+1 ? 0 : moves.get(i+5);
            if (i + 4 <= n - 1) grid[i][4] = moves.get(i+4) == -1 ? i + 5 : moves.get(i+4) == i+1 ? 0 : moves.get(i+4);
            if (i + 3 <= n - 1) grid[i][3] = moves.get(i+3) == -1 ? i + 4 : moves.get(i+3) == i+1 ? 0 : moves.get(i+3);
            if (i + 2 <= n - 1) grid[i][2] = moves.get(i+2) == -1 ? i + 3 : moves.get(i+2) == i+1 ? 0 : moves.get(i+2);
            if (i + 1 <= n - 1) grid[i][1] = moves.get(i+1) == -1 ? i + 2 : moves.get(i+1) == i+1 ? 0 : moves.get(i+1);
            if (i <= n - 1) grid[i][0] = moves.get(i) == -1 ? i + 1 : moves.get(i) == i+1 ? 0 : moves.get(i);
        }
        boolean[] visited = new boolean[n];
        return breathFirstSearch(visited, grid, 1);

    }

    private static int breathFirstSearch(boolean[] visited, int[][] graph, int start){
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


}
