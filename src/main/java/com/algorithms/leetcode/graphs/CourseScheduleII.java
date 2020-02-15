package com.algorithms.leetcode.graphs;

import java.util.*;

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseScheduleII {

    private int time = 1;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] toReturn = new int[numCourses];
        //If no prerequisites are present - return the courses array in any order
        if(prerequisites.length == 0){
            for(int i=0; i<numCourses; i++){
                toReturn[i] = i;
            }
            return toReturn;
        }
        //Convert the edge pairs in adjacency lists
        List<Integer>[] adjacencyLists = new ArrayList[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            if(adjacencyLists[prerequisites[i][1]] == null) adjacencyLists[prerequisites[i][1]] = new ArrayList();
            adjacencyLists[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        //Initialize visited, arrived and departed arrays of size numCourses;
        boolean visited[] = new boolean[numCourses];
        int arrived[] = new int[numCourses];
        int departed[] = new int[numCourses];
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        //Launch a depth first search on all the components of the graph
        for(int course=0; course<adjacencyLists.length; course++){
            if(!visited[course]){
                if(!depthFirstSearch(visited, arrived, departed, adjacencyLists, course, treeMap)){
                    return new int[0];
                }
            }
        }
        //Finally collect the sorted map values into an integer array
        Iterator<Integer> iterator = treeMap.values().iterator();
        int j=0;
        while(iterator.hasNext()){
            toReturn[j++] = iterator.next();
        }
        return toReturn;
    }

    private boolean depthFirstSearch(boolean[] visited, int[] arrived, int[] departed, List<Integer>[] adjacencyLists, int course, TreeMap<Integer, Integer> treeMap){
        if(!visited[course]){
            //Update visited to true
            visited[course] = true;
            //Update arrived time for the course
            arrived[course]= time++;
            if(adjacencyLists[course] != null) {
                for (Integer i : adjacencyLists[course]) {
                    if (!depthFirstSearch(visited, arrived, departed, adjacencyLists, i, treeMap)) {
                        return false;
                    }
                }
            }
            //Update departed time for the course
            departed[course] = time++;
            //Reverse topological sort based on departed times
            treeMap.put(0-departed[course], course);
            //System.out.println("Course = " + course + ", visited = " + visited[course] + ", arrived = " + arrived[course] + ", departed = " + departed[course]);
        }else if(arrived[course] > 0 && departed[course] == 0){
            //if arrived>0 and departed==0 then there is a cycle in directed graph.
            return false;
        }
        return true;
    }

    public static void main(String[] args){

        //Input: 4, [[1,0],[2,0],[3,1],[3,2]]
        //Output: [0,1,2,3] or [0,2,1,3]
        int numCourses = 4;
        int[][] prerequisites = new int[4][2];
        int[] prereq0 = {1,0};
        int[] prereq1 = {2,0};
        int[] prereq2 = {3,1};
        int[] prereq3 = {3,2};
        prerequisites[0] = prereq0;
        prerequisites[1] = prereq1;
        prerequisites[2] = prereq2;
        prerequisites[3] = prereq3;

        CourseScheduleII csII = new CourseScheduleII();
        int[] order = csII.findOrder(numCourses, prerequisites);
        for(int i: order){
            System.out.println(i);
        }
    }

}
