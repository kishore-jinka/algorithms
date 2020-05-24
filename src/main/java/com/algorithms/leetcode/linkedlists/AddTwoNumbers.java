package com.algorithms.leetcode.linkedlists;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode combination = new ListNode(-1);
        ListNode pointer = combination;
        int carry = 0;
        while(l1 != null || l2 != null){
            int value1 = 0;
            int value2 = 0;
            if(l1 != null){
                value1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                value2 = l2.val;
                l2 = l2.next;
            }
            int total = value1 + value2 + carry;
            ListNode node = new ListNode(total % 10);
            pointer.next = node;
            pointer = pointer.next;
            carry = total/10;
        }
        while(carry != 0){
            ListNode node = new ListNode(carry % 10);
            pointer.next = node;
            pointer = pointer.next;
            carry = carry/10;
        }
        return combination.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        //node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode combination = addTwoNumbers.addTwoNumbers(node1, node4);

        while(combination != null){
            System.out.println(combination.val);
            combination = combination.next;
        }
    }
}
