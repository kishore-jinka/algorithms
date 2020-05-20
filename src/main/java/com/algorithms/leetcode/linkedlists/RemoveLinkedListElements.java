package com.algorithms.leetcode.linkedlists;

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode pointer = head;
        while(pointer.next != null){
            if(pointer.next.val == val){
                pointer.next = pointer.next.next;
            }
            if(pointer.next != null && pointer.next.val != val) pointer = pointer.next;
        }
        if(head.val == val) return head.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        ListNode node = removeLinkedListElements.removeElements(node1, 3);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
