package com.algorithms.ik.linkedlists;

/**
 * TODO: INCOMPLETE
 */
public class MedianOfSortedCircularLinkedList {
    static int find_median(LinkedListNode ptr) {
        if(ptr == ptr.next) return ptr.val;
        int length = 1;
        LinkedListNode tortoise = ptr.next;
        while(tortoise != ptr){
            tortoise = tortoise.next;
            length++;
        }
        int medianLength = length/2;
        while(tortoise.val < tortoise.next.val){
            tortoise = tortoise.next;
        }
        tortoise = tortoise.next;
        if(length%2 == 0) medianLength = medianLength - 1;
        for(int i=0; i<medianLength; i++){
            tortoise = tortoise.next;
        }
        int median = tortoise.val;
        if(length%2 == 0){
            long average = (long)median + (long)tortoise.next.val;
            average = average/2;
            median = (int)average;
        }
        return median;
    }

    public static void main(String[] args){
        //-10
        //0
        //10
        LinkedListNode node1 = new LinkedListNode();
        node1.val = 2000000000;
        LinkedListNode node2 = new LinkedListNode();
        node2.val = 2000000000;
//        LinkedListNode node3 = new LinkedListNode();
//        node3.val = 2;
//        LinkedListNode node4 = new LinkedListNode();
//        node4.val = 4;
        node1.next = node2;
        node2.next = node1;
//        node3.next = node4;
//        node4.next = node1;
        int median = find_median(node1);
        System.out.println(median);
    }
}
