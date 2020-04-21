package com.algorithms.leetcode.linkedlists;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode leftHeadNode = head;
        ListNode rightHeadNode = head.next;
        leftHeadNode.next = null;
        return reverseLinkedList(leftHeadNode, rightHeadNode);
    }

    private ListNode reverseLinkedList(ListNode leftHeadNode, ListNode rightHeadNode){
        if(rightHeadNode == null){
            return leftHeadNode;
        }
        ListNode newLeftHeadNode = rightHeadNode;
        ListNode newRightHeadNode = rightHeadNode.next;
        newLeftHeadNode.next = leftHeadNode;
        return reverseLinkedList(newLeftHeadNode, newRightHeadNode);
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode headNode = reverseLinkedList.reverseList(listNode1);
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