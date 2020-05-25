package com.algorithms.ik.linkedlists;


import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoLinkedLists {
    static int find_intersection(LinkedListNode l1, LinkedListNode l2) {
        Map<LinkedListNode, Integer> map = new HashMap<LinkedListNode, Integer>();
        while(l1 != null){
            map.put(l1, 0);
            l1 = l1.next;
        }
        if(map.isEmpty()) return -1;
        while(l2 != null){
            if(map.get(l2) != null) return l2.val;
            l2 = l2.next;
        }
        return -1;
    }

    private class LinkedListNode {
        int val;
        LinkedListNode next;
    }
}
