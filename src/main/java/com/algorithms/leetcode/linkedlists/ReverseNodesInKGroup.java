package com.algorithms.leetcode.linkedlists;


/**
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * TODO: INCOMPLETE
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1) return head;
        ListNode returnHead = head;
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        if(head == null || head.next == null) return returnHead;
        //first k nodes
        int fastIndex=0;
        while(fastIndex<k-1 && fastPointer != null){
            fastPointer = fastPointer.next;
            fastIndex++;
        }
        if(fastIndex<k-1){
            return head;
        }else{
            returnHead = fastPointer;
        }
        int slowIndex=0;
        ListNode oldHead = null;
        ListNode newTail = head;
        while(slowIndex<k && slowPointer != null){
            ListNode temp = slowPointer;
            slowPointer = slowPointer.next;
            temp.next = oldHead;
            oldHead = temp;
            fastPointer = fastPointer.next;
            if(fastPointer != null) fastIndex++;
            if(++slowIndex==k){
                slowIndex=0;
                newTail.next = slowPointer;
                oldHead = newTail;
                if(fastIndex-slowIndex < k) {
                    break;
                }
            }
        }
        return returnHead;
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode headWithK2 = reverseNodesInKGroup.reverseKGroup(node1, 2);
        //ListNode headWithK3 = reverseNodesInKGroup.reverseKGroup(node1, 3);
        while(headWithK2 != null){
            System.out.println(headWithK2.val);
            headWithK2 = headWithK2.next;
        }
//        while(headWithK3 != null){
//            System.out.println(headWithK3.val);
//            headWithK3 = headWithK3.next;
//        }
    }
}
