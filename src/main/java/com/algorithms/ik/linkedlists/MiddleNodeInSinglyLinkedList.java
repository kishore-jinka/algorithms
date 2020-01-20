package com.algorithms.ik.linkedlists;

public class MiddleNodeInSinglyLinkedList {

    static LinkedListNode find_middle_node(LinkedListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        LinkedListNode fastPointer = head;
        LinkedListNode slowPointer = head;
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


}
