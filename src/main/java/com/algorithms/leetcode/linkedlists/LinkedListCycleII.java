package com.algorithms.leetcode.linkedlists;

/**
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
 * TODO: Incomplete - 15 / 16 test cases passed.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return head;
        ListNode tortoise = head;
        ListNode hare = head;
        boolean cycleFound = false;
        while(hare.next != null){
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare == null){
                break;
            }else if(hare.val == tortoise.val){
                cycleFound = true;
                break;
            }
        }
        if(cycleFound){
            ListNode pointer = head;
            while(pointer != tortoise){
                pointer = pointer.next;
                tortoise = tortoise.next;
            }
            return pointer;
        }
        return null;
    }
}
