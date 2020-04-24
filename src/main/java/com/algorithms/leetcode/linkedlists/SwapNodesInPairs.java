package com.algorithms.leetcode.linkedlists;

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null){
            ListNode node1 = head;
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;
            head = node2;
            head.next = node1;
            node1.next = swapPairs(node3);
        }
        return head;
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        SwapNodesInPairs swapLinkedListNodePairs = new SwapNodesInPairs();
        ListNode swappedPairsLL = swapLinkedListNodePairs.swapPairs(listNode1);
        ListNode currentNode = swappedPairsLL;
        while(currentNode != null){
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
}

/*
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
 */