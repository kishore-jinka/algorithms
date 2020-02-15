package com.algorithms.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {

    private int time = 1;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyLists = new ArrayList[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            if(adjacencyLists[prerequisites[i][1]] == null) adjacencyLists[prerequisites[i][1]] = new ArrayList();
            adjacencyLists[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean visited[] = new boolean[numCourses];
        int arrived[] = new int[numCourses];
        int departed[] = new int[numCourses];
        for(int course=0; course<adjacencyLists.length; course++){
            if(!visited[course]){
                if(!depthFirstSearch(visited, arrived, departed, adjacencyLists, course)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean depthFirstSearch(boolean[] visited, int[] arrived, int[] departed, List<Integer>[] adjacencyLists, int course){
       if(!visited[course]){
           visited[course] = true;
           arrived[course]= time++;
           if(adjacencyLists[course] != null) {
               for (Integer i : adjacencyLists[course]) {
                   if (!depthFirstSearch(visited, arrived, departed, adjacencyLists, i)) {
                       return false;
                   }
               }
           }
           departed[course] = time++;
           System.out.println("Course = " + course + ", visited = " + visited[course] + ", arrived = " + arrived[course] + ", departed = " + departed[course]);
       }else if(arrived[course] > 0 && departed[course] == 0){
           //if arrived>0 and departed==0 then there is a cycle in directed acyclic graph.
           return false;
       }
       return true;
    }


    public static void main(String[] args){
          // sample1
//        int numCourses = 4;
//        int[] prereq0 = {1,0};
//        int[] prereq1 = {2,0};
//        int[] prereq2 = {3,1};
//        int[] prereq3 = {3,2};
//        int[][] prerequisites = new int[4][2];
//        prerequisites[0] = prereq0;
//        prerequisites[1] = prereq1;
//        prerequisites[2] = prereq2;
//        prerequisites[3] = prereq3;

        // sample2
        int numCourses = 2;
        int[] prereq0 = {1,0};
        int[] prereq1 = {0,1};
        int[][] prerequisites = new int[2][2];
        prerequisites[0] = prereq0;
        prerequisites[1] = prereq1;

        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.canFinish(numCourses,prerequisites));
    }
}
