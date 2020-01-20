package com.algorithms.leetcode.linkedlists;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while(fastPointer.next != null && fastPointer.next.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        if(fastPointer.next != null){
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return  slowPointer;
    }

    public static void main(String[] args){
        //[1,2,3,4,5]
        //[1,2,3,4,5,6]
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

        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        System.out.println(middleOfLinkedList.middleNode(node1).val);
    }

}
