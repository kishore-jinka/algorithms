package com.algorithms.leetcode.linkedlists;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
 */
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(n==1) {
            if (head.next == null){
                return null;
            }else{
                ListNode pointer = head;
                while(pointer.next.next != null){
                    pointer = pointer.next;
                }
                pointer.next = null;
                return head;
            }

        }

        ListNode hare = head;
        ListNode tortoise = head;
        for(int i=0; i<n; i++){
            if(hare != null){
                hare = hare.next;
            }else{
                return head;
            }
        }
        while(hare != null){
            hare = hare.next;
            tortoise = tortoise.next;
        }
        if(tortoise.next != null){
            tortoise.val = tortoise.next.val;
            tortoise.next = tortoise.next.next;
        }
        return head;
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
        RemoveNthNode removeNthNode = new RemoveNthNode();
        ListNode node = removeNthNode.removeNthFromEnd(node1, 1);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
