package com.algorithms.leetcode.priorityqueues;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {

    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;

    public MedianFinder() {
        this.maxQueue = new PriorityQueue<Integer>(1, new DescendendingOrder());
        this.minQueue = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(maxQueue.isEmpty() && minQueue.isEmpty()){
            maxQueue.add(num);
        }else if(maxQueue.size() == 1 && minQueue.isEmpty()){
            int peekMaxQueue = maxQueue.peek();
            if(peekMaxQueue > num){
                maxQueue.poll();
                maxQueue.add(num);
                minQueue.add(peekMaxQueue);
            }else{
                minQueue.add(num);
            }
        }else if(!maxQueue.isEmpty() && !minQueue.isEmpty()){
            if(maxQueue.size() - minQueue.size() == 1){
                int peekMaxQueue = maxQueue.peek();
                if(peekMaxQueue > num){
                    maxQueue.poll();
                    maxQueue.add(num);
                    minQueue.add(peekMaxQueue);
                }else {
                    minQueue.add(num);
                }
            }else if(maxQueue.size() - minQueue.size() == 0){
                int peekMinQueue = minQueue.peek();
                if(num < peekMinQueue){
                    maxQueue.add(num);
                }else{
                    minQueue.poll();
                    minQueue.add(num);
                    maxQueue.add(peekMinQueue);
                }
            }
        }
    }

    public double findMedian() {
        if(maxQueue.size() == 1 && minQueue.isEmpty()){
            return maxQueue.peek();
        }else if(!maxQueue.isEmpty() && !minQueue.isEmpty()){
            if(maxQueue.size() - minQueue.size() == 1){
                return maxQueue.peek();
            }else if(maxQueue.size() - minQueue.size() == 0){
                double peekMinQueue = minQueue.peek();
                double peekMaxQueue = maxQueue.peek();
                return (peekMinQueue + peekMaxQueue)/2;
            }
        }
        return 0d;
    }

    private class DescendendingOrder implements Comparator<Integer>{
        public int compare(Integer o1, Integer o2) {
            int intO1 = o1;
            int intO2 = o2;
            return intO2 - intO1;
        }
    }

    public static void main(String[] args){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); //1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); //2
    }

}