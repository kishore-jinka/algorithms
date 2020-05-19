package com.algorithms.leetcode.linkedlists;

/**
 * 328. Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode frontHead = head;
        ListNode frontTail = head;
        ListNode rearHead = head.next;
        ListNode rearTail = head.next;
        while(rearTail != null && rearTail.next != null){
            ListNode copyNode = new ListNode(rearTail.next.val);
            frontTail.next = copyNode;
            copyNode.next = rearHead;
            frontTail = frontTail.next;
            rearTail.next = rearTail.next.next;
            rearTail = rearTail.next;
        }
        return frontHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode oddEvenList = oddEvenLinkedList.oddEvenList(node1);

        while(oddEvenList != null){
            System.out.println(oddEvenList.val);
            oddEvenList = oddEvenList.next;
        }
    }
}






