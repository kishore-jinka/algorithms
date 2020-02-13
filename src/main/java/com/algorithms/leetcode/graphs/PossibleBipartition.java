package com.algorithms.leetcode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 886. Possible Bipartition
 * https://leetcode.com/problems/possible-bipartition/
 */
public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(dislikes.length == 0) return true;
        if(dislikes.length == 1) return true;
        List[] graph = new ArrayList[N];
        for(int i=0; i<dislikes.length; i++){
            if(graph[dislikes[i][0] - 1] == null) graph[dislikes[i][0]-1] = new ArrayList();
            graph[dislikes[i][0] - 1].add(dislikes[i][1]);

            if(graph[dislikes[i][1] - 1] == null) graph[dislikes[i][1]-1] = new ArrayList();
            graph[dislikes[i][1] - 1].add(dislikes[i][0]);
        }
//        for(int i=0; i<N; i++){
//            System.out.println("graph["+(i+1)+"] = " + graph[i]);
//        }
        return isBipartite(N, graph);
    }

    private boolean isBipartite(int N, List[] graph) {
        int[] visited = new int[N];
        for(int i=1; i<=N; i++){
            if(visited[i-1] == 0){
                boolean isBipartite = breathFirstSearch(graph, visited, i);
                if(!isBipartite){
//                    for(int j=0; j<visited.length; j++){
//                        System.out.println("visited["+(j+1)+"] = " + visited[j]);
//                    }
                    return false;
                }
            }
        }
//        for(int j=0; j<visited.length; j++){
//            System.out.println("visited["+(j+1)+"] = " + visited[j]);
//        }
        return true;
    }

    private boolean breathFirstSearch(List[] graph, int[] visited, int vertex){
        Queue<Integer> queue = new LinkedList();
        queue.add(vertex);
        while(!queue.isEmpty()){
            Integer next = queue.poll();
            List<Integer> neighbors = graph[next-1];
            if(neighbors == null || neighbors.size() == 0){
                continue;
            }
            if(visited[next-1] == 0) visited[next-1] = 1;
            int parentVisitedValue = visited[next-1];
            for(int neighbor : neighbors){
                if(visited[neighbor-1] == 0){
                    visited[neighbor-1] = 0 - parentVisitedValue;
                    queue.add(neighbor);
                }else if(visited[neighbor-1] == parentVisitedValue){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] dislikes = new int[5][2];
        int[] array0 = {1,2};
        dislikes[0] = array0;
        int[] array1 = {2,3};
        dislikes[1] = array1;
        int[] array2 = {3,4};
        dislikes[2] = array2;
        int[] array3 = {4,5};
        dislikes[3] = array3;
        int[] array4 = {1,5};
        dislikes[4] = array4;
        PossibleBipartition pb = new PossibleBipartition();
        System.out.println(pb.possibleBipartition(5, dislikes));
    }

}

/*
Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 */