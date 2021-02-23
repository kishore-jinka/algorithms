package com.algorithms.leetcode.graphs;

import java.util.*;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/submissions/
 */
public class ConnectedComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        if(n==0) return 0;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] edge : edges){
            if(map.get(edge[0]) == null) map.put(edge[0], new ArrayList());
            if(map.get(edge[1]) == null) map.put(edge[1], new ArrayList());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i, visited, map);
                count++;
            }
        }
        return count;
    }

    private void bfs(int node, boolean[] visited, Map<Integer, List<Integer>> map){
        Queue<Integer> queue = new LinkedList();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int toVisit = queue.poll();
            List<Integer> neighbors = map.get(toVisit);
            if(neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        ConnectedComponentsInUndirectedGraph cciug = new ConnectedComponentsInUndirectedGraph();
        //int[][] edges = {{0, 1}, {1, 2},{3, 4}};
        //int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int n = 5;
        //int[][] edges = {{1, 0}};
        //int n = 2;
        int count = cciug.countComponents(n, edges);
        System.out.println(count);
    }
}
