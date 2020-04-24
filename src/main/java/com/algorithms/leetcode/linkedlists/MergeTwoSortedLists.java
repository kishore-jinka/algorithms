package com.algorithms.leetcode.linkedlists;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null && l2 != null) return l2;
        if(l2 == null && l1 != null) return l1;
        ListNode headNode = null;
        ListNode tailNode = null;
        if(l1.val <= l2.val){
            headNode = l1;
            tailNode = l1;
            mergeTwoListsToOne(tailNode, l1.next, l2);
        }else{
            headNode = l2;
            tailNode = l2;
            mergeTwoListsToOne(tailNode, l1, l2.next);
        }
        return headNode;
    }

    private void mergeTwoListsToOne(ListNode tailNode, ListNode l1, ListNode l2){
        if(l1 == null && l2 != null) {
            tailNode.next = l2;
            return;
        }
        if(l2 == null && l1 != null){
            tailNode.next = l1;
            return;
        }
        if(l1.val <= l2.val){
            tailNode.next = new ListNode(l1.val);
            mergeTwoListsToOne(tailNode.next, l1.next, l2);
        }else{
            tailNode.next = new ListNode(l2.val);
            mergeTwoListsToOne(tailNode.next, l1, l2.next);
        }
    }

    public static void main(String[] args){
        ListNode first1 = new ListNode(1);
        ListNode first2 = new ListNode(2);
        ListNode first3 = new ListNode(4);
        first1.next = first2;
        first2.next = first3;
        ListNode second1 = new ListNode(1);
        ListNode second2 = new ListNode(3);
        ListNode second3 = new ListNode(4);
        second1.next = second2;
        second2.next = second3;
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode mergedListHeadNode =  mtsl.mergeTwoLists(first1, second1);
        if(mergedListHeadNode != null) System.out.println(mergedListHeadNode.val);
        while(mergedListHeadNode.next != null){
            System.out.println(mergedListHeadNode.next.val);
            mergedListHeadNode = mergedListHeadNode.next;
        }

    }
}
