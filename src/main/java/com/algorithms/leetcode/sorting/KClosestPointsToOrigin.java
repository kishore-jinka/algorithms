package com.algorithms.leetcode.sorting;


/**
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        partitionKClosest(points, K, 0, points.length -1);
        int[][] toReturn = new int[K][2];
        for(int i=0; i<K; i++){
            toReturn[i] = points[i];
        }
        return toReturn;
    }

    private void partitionKClosest(int[][] points, int k, int start, int end){
        if(start == end) return;
        int orangeIndex = findLomutosPartitionIndex(points, start, end);
        if(orangeIndex < k-1) partitionKClosest(points, k, orangeIndex+1, end);
        if(orangeIndex > k-1) partitionKClosest(points, k, start, orangeIndex-1);
        if(orangeIndex == k-1) return;
    }

    private int findLomutosPartitionIndex(int[][] points, int start, int end){
        int orangeIndex = start-1;
        double pivot = getEuclideanDistance(points[end][0], points[end][1]);
        for(int greenIndex = start; greenIndex <= end; greenIndex ++){
            if(getEuclideanDistance(points[greenIndex][0], points[greenIndex][1]) <= pivot){
                orangeIndex ++;
                int[] temp = points[greenIndex];
                points[greenIndex] = points[orangeIndex];
                points[orangeIndex] = temp;
            }
        }
        return orangeIndex;
    }

    private double getEuclideanDistance(int x, int y){
        return Math.sqrt(x*x + y*y);
    }

    public static void main(String[] args){
        int[][] points = {{1,3},{-2,2}};
        int K = 1;
        //int[][] points = {{3,3},{5,-1},{-2,4}};
        //int K = 2;
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] closestPoints = kClosestPointsToOrigin.kClosest(points, K);
        for(int i=0; i<K; i++){
            System.out.println(closestPoints[i][0] + ", " + closestPoints[i][1]);
        }
    }

}
