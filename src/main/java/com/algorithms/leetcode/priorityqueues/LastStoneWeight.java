package com.algorithms.leetcode.priorityqueues;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 * https://leetcode.com/problems/last-stone-weight/
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(stones.length, new DescendendingOrder());
        for(int i: stones){
            pq.add(i);
        }
        while(pq.size() > 1){
            int big = pq.poll();
            int small = pq.poll();
            if(big > small){
                pq.add(big-small);
            }
        }
        if(pq.size() == 1) return pq.poll();
        return 0;
    }

    private class DescendendingOrder implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            int intO1 = o1;
            int intO2 = o2;
            return intO2 - intO1;
        }
    }

    public static void main(String[] args){
        int[] stones = {2,7,4,1,8,1};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(stones));
    }
}
