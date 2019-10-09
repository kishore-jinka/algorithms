package com.algorithms.recursion;


public class ReverseLinkedList {
    public ListNodeLeetCode reverseList(ListNodeLeetCode head) {
        ListNodeLeetCode lastNode = head;

        return head;
    }

    public static void main(String[] args){
        ListNodeLeetCode listNode1 = new ListNodeLeetCode(1);
        ListNodeLeetCode listNode2 = new ListNodeLeetCode(2);
        ListNodeLeetCode listNode3 = new ListNodeLeetCode(3);
        ListNodeLeetCode listNode4 = new ListNodeLeetCode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNodeLeetCode headNode = reverseLinkedList.reverseList(listNode1);
        while(headNode != null){
            System.out.println(headNode.val);
            headNode = headNode.next;
        }
    }
}

/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
 */