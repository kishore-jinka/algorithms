package com.algorithms.others.arrays;

public class SumOfSeries {
    //O(N) algorithm
    public int seriesSum(int k){
        int[] series = new int[k];
        series[0] = 1;
        int sum = series[0];
        for(int i=1; i<series.length; i++) {
            series[i] = series[i - 1] + i + 1;
            sum = sum + series[i];
        }
        return sum;
    }

    public static void main(String[] args){
        SumOfSeries sumOfSeries = new SumOfSeries();
        System.out.println(sumOfSeries.seriesSum(5));
    }
}
