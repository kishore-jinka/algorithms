package com.algorithms.leetcode.sorting;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * //TODO: INCOMPLETE: Time Limit Exceeded
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int tailsReached = 0;
        ListNode mergedList = null;
        ListNode mergedHead = null;
        while(tailsReached<lists.length) {
            //int linkedListIndex=0;
            for (int linkedListIndex=0; linkedListIndex < lists.length; linkedListIndex++) {
                ListNode headNode = lists[linkedListIndex];
                if (headNode != null) {
                    if (pq.size() < lists.length) {
                        pq.add(headNode.val);
                    } else {
                        ListNode newNode = null;
                        if (pq.peek().intValue() < headNode.val) {
                            newNode = new ListNode(pq.poll());
                            pq.add(headNode.val);
                        } else {
                            newNode = new ListNode(headNode.val);
                        }
                        if (mergedList == null) {
                            mergedList = newNode;
                            mergedHead = mergedList;
                        } else {
                            mergedList.next = newNode;
                            mergedList = mergedList.next;
                        }
                    }
                    headNode = headNode.next;
                    lists[linkedListIndex] = headNode;
                    if (headNode == null) tailsReached++;
                }
            }
        }
        while(!pq.isEmpty()){
            ListNode newNode = new ListNode(pq.poll());
            mergedList.next = newNode;
            mergedList = mergedList.next;
        }
        return mergedHead;
    }

    public static void main(String[] args){
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(4);
        ListNode list1Node3 = new ListNode(5);
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;


        ListNode list2Node1 = new ListNode(1);
        ListNode list2Node2 = new ListNode(3);
        ListNode list2Node3 = new ListNode(4);
        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;

        ListNode list3Node1 = new ListNode(2);
        ListNode list3Node2 = new ListNode(6);
        list3Node1.next = list3Node2;

        ListNode[] array = new ListNode[3];
        array[0] = list1Node1;
        array[1] = list2Node1;
        array[2] = list3Node1;

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode finalList = mergeKSortedLists.mergeKLists(array);

        while(finalList != null){
            System.out.print(finalList.val + "->");
            finalList = finalList.next;
        }
    }
}

/**
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
