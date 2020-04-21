package com.algorithms.leetcode.linkedlists;

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pointer = head;
        while(pointer.next != null){
            if(pointer.val == pointer.next.val){
                pointer.next = pointer.next.next;
            }else {
                pointer = pointer.next;
            }
        }
        return head;
    }
}
