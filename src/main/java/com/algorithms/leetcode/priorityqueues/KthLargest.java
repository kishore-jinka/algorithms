package com.algorithms.leetcode.priorityqueues;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargest {

    private PriorityQueue<Integer> priorityQueue;
    private int capacity;

    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        this.priorityQueue = new PriorityQueue<Integer>(capacity);
        for(int i : nums){
            if(priorityQueue.size() < capacity){
                priorityQueue.add(i);
            }else if(priorityQueue.size() == capacity && priorityQueue.peek() < i){
               priorityQueue.poll();
               priorityQueue.add(i);
            }
        }
    }

    public int add(int val) {
        if(priorityQueue.size() < capacity){
            priorityQueue.add(val);
        }else if(priorityQueue.size() == capacity && priorityQueue.peek() < val){
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args){
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}