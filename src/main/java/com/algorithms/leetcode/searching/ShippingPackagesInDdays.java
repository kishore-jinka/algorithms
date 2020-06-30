package com.algorithms.leetcode.searching;

/**
 * 1011. Capacity To Ship Packages Within D Days
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class ShippingPackagesInDdays {
    public int shipWithinDays(int[] weights, int D) {
        int start = weights[0];
        int end = weights[0];
        for(int i=1; i<weights.length; i++){
            start = Math.max(start, weights[i]);
            end = end + weights[i];
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            double load = 0d;
            int days = 1;
            for(int i=0; i<weights.length; i++){
                load = load + weights[i];
                if(load/mid > 1.0){
                    days = days + 1;
                    load = weights[i];
                }
            }
            if(days > D){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args){
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        ShippingPackagesInDdays shippingPackagesInDdays = new ShippingPackagesInDdays();
        System.out.println(shippingPackagesInDdays.shipWithinDays(weights, D));
    }
}
