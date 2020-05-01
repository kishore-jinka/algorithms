package com.algorithms.leetcode.hashtable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 * https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if(k<1) return new int[0];
        if(nums.length < 2) return nums;
        Map<Integer, Integer> map = new HashMap();
        for(int i : nums){
            if(map.get(i)  == null){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i) + 1);
            }
        }
        PriorityQueue<FrequencyKey> priorityQueue = new PriorityQueue(1, new AscendingOrder());
        for(int i : map.keySet()){
            if(priorityQueue.size() < k){
                priorityQueue.add(new FrequencyKey(map.get(i), i));
            }else if(priorityQueue.size() == k){
                if(priorityQueue.peek().frequency < map.get(i)){
                    priorityQueue.poll();
                    priorityQueue.add(new FrequencyKey(map.get(i), i));
                }
            }
        }
        int[] toReturn = new int[priorityQueue.size()];
        for(int i=0; i<toReturn.length; i++){
            toReturn[i] = priorityQueue.poll().key;
        }
        return toReturn;
    }

    private class FrequencyKey{
        int frequency;
        int key;
        FrequencyKey(int frequency, int key){
            this.frequency = frequency;
            this.key = key;
        }
    }

    private class AscendingOrder implements Comparator<FrequencyKey> {
        public int compare(FrequencyKey fk1, FrequencyKey fk2) {
            return fk1.frequency - fk2.frequency;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        nums = topKFrequentElements.topKFrequent(nums, 2);
        for(int i:nums){
            System.out.println(i);
        }
    }
}



