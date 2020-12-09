package com.algorithms.ik.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Zombie Clusters
 * https://oj.interviewkickstart.com/view_test_problem/5370/130/
 */
public class ZombieClusters {

    public static int zombieCluster(List<String> zombies) {
        List<Integer>[] graph = new ArrayList[zombies.size()];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList();
        }
        for(int i=0; i<zombies.size(); i++){
            char[] chars = zombies.get(i).toCharArray();
            for(int j=0; j<chars.length; j++){
                if(i==j) continue;
                if(chars[j] == '1'){
                    graph[i].add(j);
                }
            }
        }
        boolean[] visited = new boolean[zombies.size()];
        int connectedGroups = 0;
        for(int zombie=0; zombie<zombies.size(); zombie++){
            if(!visited[zombie]){
                breathFirstSearch(graph, visited, zombie);
                connectedGroups++;
            }
        }
        return connectedGroups;
    }

    private static void breathFirstSearch(List<Integer>[] graph, boolean[] visited, int zombie){
        Queue<Integer> queue = new LinkedList();
        queue.add(zombie);
        visited[zombie] = true;
        while(!queue.isEmpty()){
            Integer next = queue.poll();
            List<Integer> neighbors = graph[next];
            for(int neighbor : neighbors){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args){
        List<String> zombieClusters = new ArrayList();
        zombieClusters.add("1100");
        zombieClusters.add("1110");
        zombieClusters.add("0110");
        zombieClusters.add("0001");
        int numberOfClusters = zombieCluster(zombieClusters);
        System.out.println(numberOfClusters);
    }
}
