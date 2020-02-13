package com.algorithms.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. Is Graph Bipartite?
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        if(graph.length == 0) return false;
        if(graph.length == 1) return true;
        int[] visited = new int[graph.length];
        for(int i=0; i<visited.length; i++){
            if(visited[i] == 0){
                boolean isBipartite = breathFirstSearch(graph, visited, i);
                if(!isBipartite){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean breathFirstSearch(int[][] graph, int[] visited, int vertex){
        Queue<Integer> queue = new LinkedList();
        queue.add(vertex);
        while(!queue.isEmpty()){
            Integer next = queue.poll();
            int[] neighbors = graph[next];
            if(neighbors.length == 0){
                continue;
            }
            if(visited[next] == 0) visited[next] = 1;
            int parentVisitedValue = visited[next];
            for(int neighbor : neighbors){
                if(visited[neighbor] == 0){
                    visited[neighbor] = 0 - parentVisitedValue;
                    queue.add(neighbor);
                }else if(visited[neighbor] == parentVisitedValue){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
//        int[][] graph = new int[5][1];
//        int[] emptyArray = {};
//        graph[0] =  emptyArray;
//        graph[1][0] = 3;
//        graph[2] = emptyArray;
//        graph[3][0] = 1;
//        graph[4] = emptyArray;

        int[][] graph = new int[50][4];
        int[] array0={2,4};
        int[] array1={2,3,4};
        int[] array2={0,1};
        int[] array3={1};
        int[] array4={0,1};
        int[] array5={7};
        int[] array6={9};
        int[] array7={5};
        int[] array8={};
        int[] array9={6};
        int[] array10={12,14};
        int[] array11={};
        int[] array12={10};
        int[] array13={};
        int[] array14={10};
        int[] array15={19};
        int[] array16={18};
        int[] array17={};
        int[] array18={16};
        int[] array19={15};
        int[] array20={23};
        int[] array21={23};
        int[] array22={};
        int[] array23={20,21};
        int[] array24={};
        int[] array25={};
        int[] array26={27};
        int[] array27={26};
        int[] array28={};
        int[] array29={};
        int[] array30={34};
        int[] array31={33,34};
        int[] array32={};
        int[] array33={31};
        int[] array34={30,31};
        int[] array35={38,39};
        int[] array36={37,38,39};
        int[] array37={36};
        int[] array38={35,36};
        int[] array39={35,36};
        int[] array40={43};
        int[] array41={};
        int[] array42={};
        int[] array43={40};
        int[] array44={};
        int[] array45={49};
        int[] array46={47,48,49};
        int[] array47={46,48,49};
        int[] array48={46,47,49};
        int[] array49={45,46,47,48};

        graph[0] = array0;
        graph[1] = array1;
        graph[2] = array2;
        graph[3] = array3;
        graph[4] = array4;
        graph[5] = array5;
        graph[6] = array6;
        graph[7] = array7;
        graph[8] = array8;
        graph[9] = array9;

        graph[10] = array10;
        graph[11] = array11;
        graph[12] = array12;
        graph[13] = array13;
        graph[14] = array14;
        graph[15] = array15;
        graph[16] = array16;
        graph[17] = array17;
        graph[18] = array18;
        graph[19] = array19;

        graph[20] = array20;
        graph[21] = array21;
        graph[22] = array22;
        graph[23] = array23;
        graph[24] = array24;
        graph[25] = array25;
        graph[26] = array26;
        graph[27] = array27;
        graph[28] = array28;
        graph[29] = array29;

        graph[30] = array30;
        graph[31] = array31;
        graph[32] = array32;
        graph[33] = array33;
        graph[34] = array34;
        graph[35] = array35;
        graph[36] = array36;
        graph[37] = array37;
        graph[38] = array38;
        graph[39] = array39;

        graph[40] = array40;
        graph[41] = array41;
        graph[42] = array42;
        graph[43] = array43;
        graph[44] = array44;
        graph[45] = array45;
        graph[46] = array46;
        graph[47] = array47;
        graph[48] = array48;
        graph[49] = array49;

        IsGraphBipartite isGraphBipartite = new IsGraphBipartite();
        System.out.println(isGraphBipartite.isBipartite(graph));
    }

}

/*
Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation:
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation:
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.





for(int j=0; j<visited.length; j++){
                        System.out.println("visited["+j+"] = " + visited[j]);
                    }









[
int[] array={2,4};
int[] array={2,3,4};
int[] array={0,1};
int[] array={1};
int[] array={0,1};
int[] array={7};
int[] array={9};
int[] array={5};
int[] array={};
int[] array={6};
int[] array={12,14};
int[] array={};
int[] array={10};
int[] array={};
int[] array={10};
int[] array={19};
int[] array={18};
int[] array={};
int[] array={16};
int[] array={15};
int[] array={23};
int[] array={23};
int[] array={};
int[] array={20,21};
int[] array={};
int[] array={};
int[] array={27};
int[] array={26};
int[] array={};
int[] array={};
int[] array={34};
int[] array={33,34};
int[] array={};
int[] array={31};
int[] array={30,31};
int[] array={38,39};
int[] array={37,38,39};
int[] array={36};
int[] array={35,36};
int[] array={35,36};
int[] array={43};
int[] array={};
int[] array={};
int[] array={40};
int[] array={};
int[] array={49};
int[] array={47,48,49};
int[] array={46,48,49};
int[] array={46,47,49};
int[] array={45,46,47,48};
]
 */