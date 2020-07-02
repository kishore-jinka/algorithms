package com.algorithms.leetcode.searching;

/**
 * 774. Minimize Max Distance to Gas Station
 * https://leetcode.com/problems/minimize-max-distance-to-gas-station/
 */
public class MinimizeMaxDistance {
    public double minmaxGasDist(int[] stations, int K) {
        double start = 0d;
        double end = 0d;
        for(int i=0; i<stations.length - 1; i++){
            end = Math.max(end, stations[i+1] - stations[i]);
        }
        while(start <= end - 0.000001){
            double mid = start + (end - start)/2.0;
            int numOfStations = 0;
            for(int i=0; i<stations.length - 1; i++){
                numOfStations = numOfStations + (int) Math.floor((stations[i+1] - stations[i])/mid);
            }
            if(numOfStations > K){
                //not feasible
                start = mid;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
