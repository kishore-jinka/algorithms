package com.algorithms.leetcode.priorityqueues;

import com.algorithms.leetcode.linkedlists.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, new ComparatorImpl());
        for(ListNode listNode : lists){
            if(listNode != null) priorityQueue.add(listNode);
        }
        ListNode headNode = new ListNode(0);
        ListNode pointerNode = headNode;
        while(!priorityQueue.isEmpty()){
            ListNode toAttach = priorityQueue.poll();
            pointerNode.next = new ListNode(toAttach.val);
            pointerNode = pointerNode.next;
            if(toAttach.next != null) priorityQueue.add(toAttach.next);
        }
        return headNode.next;
    }

    private class ComparatorImpl implements Comparator<ListNode> {
        public int compare(ListNode listNode1, ListNode listNode2) {
            return listNode1.val - listNode2.val;
        }
    }

    public static void main(String[] args){

        ListNode node11 = new ListNode(1);
        ListNode node14 = new ListNode(4);
        ListNode node15 = new ListNode(5);
        node11.next = node14;
        node14.next = node15;

        ListNode node21 = new ListNode(1);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(4);
        node21.next = node23;
        node23.next = node24;

        ListNode node32 = new ListNode(2);
        ListNode node36 = new ListNode(6);
        node32.next = node36;

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = node11;
        lists[1] = node21;
        lists[2] = node32;

        ListNode merged = mergeKSortedLists.mergeKLists(lists);

        while(merged != null){
            System.out.println(merged.val);
            merged = merged.next;
        }
    }
}
