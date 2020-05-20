package com.algorithms.leetcode.linkedlists;

import java.util.Stack;

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode pointer = head;
        int length = 0;
        while(pointer != null){
            length++;
            pointer = pointer.next;
        }
        pointer = head;
        Stack<Integer> stack = new Stack<Integer>();
        int i=0;
        while(i<length/2){
            stack.push(pointer.val);
            pointer = pointer.next;
            i++;
        }
        if(length % 2 == 1){
            pointer = pointer.next;
        }
        while(pointer != null){
            if(pointer.val == stack.peek()){
                pointer = pointer.next;
                stack.pop();
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(6);
//        ListNode node5 = new ListNode(3);
//        ListNode node6 = new ListNode(2);
//        ListNode node7 = new ListNode(2);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(node1));
    }
}
