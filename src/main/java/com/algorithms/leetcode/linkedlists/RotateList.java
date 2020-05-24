package com.algorithms.leetcode.linkedlists;

/**
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int length = 0;
        ListNode tortoise = head;
        while(tortoise != null){
            tortoise = tortoise.next;
            length++;
        }
        k = k%length;
        if(k == 0) return head;
        tortoise = head;
        ListNode hare = head;
        //ListNode oldHead = head;
        int diff = 0;
        while(diff < k){
            hare = hare.next;
            diff++;
        }
        while(hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next;
        }
        ListNode newHead = tortoise.next;
        tortoise.next = null;
        hare.next = head;
        return newHead;
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
        RotateList rotateList = new RotateList();
        ListNode node = rotateList.rotateRight(node1, 2);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
