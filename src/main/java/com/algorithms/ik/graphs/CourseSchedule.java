package com.algorithms.ik.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Course Schedule
 * https://oj.interviewkickstart.com/view_test_problem/5370/132/
 * TODO INCOMPLETE: 18 / 22 test cases passed successfully.
 *
 * LeetCode 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseSchedule {

    private static int time = 0;
    static List<Integer> course_schedule(int n, List<List<Integer>> prerequisites) {
        List<Integer> toReturn = new ArrayList();
        //If no prerequisites are present - return the courses array in any order
        if(prerequisites.size() == 0){
            for(int i=0; i<n; i++){
                toReturn.add(i);
            }
            return toReturn;
        }
        //Convert the edge pairs in adjacency lists
        List<Integer>[] adjacencyLists = new ArrayList[n];
        for(int i=0; i<prerequisites.size(); i++){
            if(adjacencyLists[prerequisites.get(i).get(1)] == null) adjacencyLists[prerequisites.get(i).get(1)] = new ArrayList();
            adjacencyLists[prerequisites.get(i).get(1)].add(prerequisites.get(i).get(0));
        }
        //Initialize visited, arrived and departed arrays of size numCourses;
        boolean visited[] = new boolean[n];
        int arrived[] = new int[n];
        int departed[] = new int[n];
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        //Launch a depth first search on all the components of the graph
        for(int course=0; course<adjacencyLists.length; course++){
            if(!visited[course]){
                if(!depthFirstSearch(visited, arrived, departed, adjacencyLists, course, treeMap)){
                    toReturn.add(-1);
                    return toReturn;
                }
            }
        }
        //Finally collect the sorted map values into an integer array
        Iterator<Integer> iterator = treeMap.values().iterator();
        while(iterator.hasNext()){
            toReturn.add(iterator.next());
        }
        return toReturn;
    }

    private static boolean depthFirstSearch(boolean[] visited, int[] arrived, int[] departed, List<Integer>[] adjacencyLists, int course, TreeMap<Integer, Integer> treeMap){
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
}
