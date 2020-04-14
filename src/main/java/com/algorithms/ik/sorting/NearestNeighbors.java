package com.algorithms.ik.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Similar to 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class NearestNeighbors {
    public static List<List<Integer>> nearest_neighbours(int p_x, int p_y, int k, List<List<Integer>> n_points) {
        partitionKClosest(p_x, p_y, k, n_points, 0, n_points.size() -1);
        return n_points.subList(0, k);
    }

    private static void partitionKClosest(int p_x, int p_y, int k, List<List<Integer>> n_points, int start, int end){
        if(start == end) return;
        int orangeIndex = findLomutosPartitionIndex(p_x, p_y, n_points, start, end);
        if(orangeIndex < k-1) partitionKClosest(p_x, p_y, k, n_points, orangeIndex+1, end);
        if(orangeIndex > k-1) partitionKClosest(p_x, p_y, k, n_points, start, orangeIndex-1);
        if(orangeIndex == k-1) return;
    }

    private static int findLomutosPartitionIndex(int p_x, int p_y, List<List<Integer>> n_points, int start, int end){
        int orangeIndex = start-1;
        double pivot = getEuclideanDistance(n_points.get(end).get(0), n_points.get(end).get(1), p_x, p_y);
        for(int greenIndex = start; greenIndex <= end; greenIndex ++){
            if(getEuclideanDistance(n_points.get(greenIndex).get(0), n_points.get(greenIndex).get(1), p_x, p_y) <= pivot){
                orangeIndex ++;
                List<Integer> temp = n_points.get(greenIndex);
                n_points.set(greenIndex,n_points.get(orangeIndex));
                n_points.set(orangeIndex,temp);
            }
        }
        return orangeIndex;
    }

    private static double getEuclideanDistance(int x, int y, int p_x, int p_y){
        int xDiff = x-p_x;
        int yDiff = y-p_y;
        double xDiffSquared = xDiff*xDiff;
        double yDiffSquared = yDiff*yDiff;
        return Math.sqrt(xDiffSquared + yDiffSquared);
    }

    public static void main(String[] args){

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list0 = new ArrayList();
        list0.add(1);
        list0.add(3);

        List<Integer> list1 = new ArrayList();
        list1.add(-2);
        list1.add(2);

//        List<Integer> list2 = new ArrayList();
//        list2.add(-1000000000);
//        list2.add(1000000000);
//
//        List<Integer> list3 = new ArrayList();
//        list3.add(1000000000);
//        list3.add(-1000000000);

        list.add(list0);
        list.add(list1);
        //list.add(list2);
        //list.add(list3);

        /*
        -1000000000 -1000000000
0 0
        -1000000000 1000000000
         1000000000 -1000000000
         */
        List<List<Integer>> kClosest = nearest_neighbours(0,0,1, list);
        for(int i=0; i<kClosest.size(); i++){
            System.out.println(kClosest.get(i).get(0) + ", " + kClosest.get(i).get(1));
        }
    }

}
