package com.algorithms.leetcode.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 346. Moving Average from Data Stream
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1368/
 */
public class MovingAverage {

    Queue<Integer> queue;
    double movingAverage;
    int size;
    public MovingAverage(int size) {
        queue = new LinkedList();
        this.size = size;
    }

    public double next(int val) {
        if(queue.size() == 0){
            movingAverage = val;
            queue.add(val);
        }else if(queue.size() < size){
            movingAverage = (movingAverage * queue.size() + val)/(queue.size() + 1);
            queue.add(val);
        }else if(queue.size() == size){
            movingAverage = (movingAverage * size - queue.peek() + val)/size;
            queue.poll();
            queue.add(val);
        }
        return movingAverage;
    }

    public static void main(String[] args){
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1)); // 1
        System.out.println(m.next(10)); // (1 + 10) / 2
        System.out.println(m.next(3)); // (1 + 10 + 3) / 3
        System.out.println(m.next(5)); // (10 + 3 + 5) / 3
    }
}
