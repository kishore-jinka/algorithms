package com.algorithms.ik.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Detect Cycle In Directed Graph
 * https://oj.interviewkickstart.com/view_test_problem/6556/121/
 * TODO INCOMPLETE: 20 / 24 test cases passed successfully.
 */
public class DetectCycleInDirectedGraph {

    private static int time=0;
    public static boolean hasCycle(int N, int M, List<List<Integer>> edges) {
        if(edges.size() == 0) return false;
        List<Integer>[] adjacencyLists = new ArrayList[N];
        for(int i=0; i<edges.size(); i++){
            if(adjacencyLists[edges.get(i).get(0)] == null) adjacencyLists[edges.get(i).get(0)] = new ArrayList();
            adjacencyLists[edges.get(i).get(0)].add(edges.get(i).get(1));
        }
        boolean visited[] = new boolean[N];
        int arrived[] = new int[N];
        int departed[] = new int[N];
        time=0;
        for(int vertex=0; vertex<adjacencyLists.length; vertex++){
            if(!visited[vertex]){
                if(depthFirstSearch(visited, arrived, departed, adjacencyLists, vertex)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean depthFirstSearch(boolean[] visited, int[] arrived, int[] departed, List<Integer>[] adjacencyLists, int vertex){
        if(!visited[vertex] || (visited[vertex] && departed[vertex] == 0)){
            visited[vertex] = true;
            arrived[vertex]= time++;
            if(adjacencyLists[vertex] != null) {
                for (Integer i : adjacencyLists[vertex]) {
                    if (depthFirstSearch(visited, arrived, departed, adjacencyLists, i)) {
                        return true;
                    }
                }
            }
            departed[vertex] = time++;
            //System.out.println("Vertex = " + vertex + ", visited = " + visited[vertex] + ", arrived = " + arrived[vertex] + ", departed = " + departed[vertex]);
        }else if(arrived[vertex] > 0 && departed[vertex] == 0){
            //if arrived>0 and departed==0 then there is a cycle in directed graph.
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        List<Integer> edges0 = new ArrayList();
        edges0.add(0);
        edges0.add(1);
        List<Integer> edges1 = new ArrayList();
        edges1.add(1);
        edges1.add(0);
        List<List<Integer>> edges = new ArrayList();
        edges.add(edges0);
        edges.add(edges1);
        boolean hasCycle = hasCycle(2,2, edges);
        System.out.println(hasCycle);
    }
}
