package com.algorithms.ik.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Longest Path In Weighted DAG
 * https://oj.interviewkickstart.com/view_test_problem/6556/123/
 * TODO: INCOMPLETE
 */
public class LongestPathInWeightedDAG {

    static int[] find_longest_path(int dag_nodes, int[] dag_from, int[] dag_to, int[] dag_weight, int from_node, int to_node) {
        Queue<Integer> queue = new LinkedList();
        queue.add(from_node);
        int[] pathsSums = new int[dag_nodes];
        List<Integer>[] paths = new List[dag_nodes];
        for(int i=0; i<paths.length; i++) paths[i] = new ArrayList();
        boolean[] dagUsed = new boolean[dag_from.length];
        while(!queue.isEmpty()){
            int from = queue.poll();
            for(int fromIndex=0; fromIndex<dag_from.length; fromIndex++){
                if(dag_from[fromIndex] == from && !dagUsed[fromIndex]){
                    int to = dag_to[fromIndex];
                    int weight = dag_weight[fromIndex];
                    if(pathsSums[from-1] + weight > pathsSums[to-1]){
                        pathsSums[to-1] = pathsSums[from-1] + weight;
                        paths[to-1] = new ArrayList();
                        paths[to-1].addAll(paths[from-1]);
                        paths[to-1].add(from);
                    }
                    queue.add(to);
                    dagUsed[fromIndex] = true;

                }
            }
        }
        List<Integer> longestPath = paths[to_node-1];
        int[] longestPathArray = new int[longestPath.size()+1];
        for(int i=0; i<longestPath.size(); i++){
            longestPathArray[i] = longestPath.get(i);
        }
        longestPathArray[longestPath.size()] = to_node;
        return longestPathArray;
    }

    public static void main(String[] args){
        int dag_nodes = 4;
        int[] dag_from = {1, 1, 1, 3};
        int[] dag_to = {2, 3, 4, 4};
        int[] dag_weight = {2, 2, 4, 3};
        int from_node = 1;
        int to_node = 4;
        int[] longestPath = find_longest_path(dag_nodes, dag_from, dag_to, dag_weight, from_node, to_node);
        for(int node : longestPath){
            System.out.println(node);
        }
    }
}
