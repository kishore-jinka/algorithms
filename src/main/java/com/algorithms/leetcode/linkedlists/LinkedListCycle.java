package com.algorithms.leetcode.linkedlists;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode tortoise = head;
        ListNode hare = head;
        while(hare.next != null){
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare == null){
                break;
            }else{
                if(hare.val == tortoise.val) return true;
            }
        }
        return false;
    }
}
