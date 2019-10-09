package com.algorithms.recursion;

public class SwapLinkedListNodePairs {
    public ListNodeLeetCode swapPairs(ListNodeLeetCode head) {
        if(head != null && head.next != null){
            ListNodeLeetCode node1 = head;
            ListNodeLeetCode node2 = node1.next;
            ListNodeLeetCode node3 = node2.next;
            head = node2;
            head.next = node1;
            node1.next = swapPairs(node3);
        }
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
        SwapLinkedListNodePairs swapLinkedListNodePairs = new SwapLinkedListNodePairs();
        ListNodeLeetCode swappedPairsLL = swapLinkedListNodePairs.swapPairs(listNode1);
        ListNodeLeetCode currentNode = swappedPairsLL;
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