package com.algorithms.leetcode.linkedlists;

import java.util.HashMap;
import java.util.Map;

/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        while(headA != null){
            map.put(headA, 0);
            headA = headA.next;
        }
        if(map.isEmpty()) return null;
        while(headB != null){
            if(map.get(headB) != null) return headB;
            headB = headB.next;
        }
        return null;
    }
}
