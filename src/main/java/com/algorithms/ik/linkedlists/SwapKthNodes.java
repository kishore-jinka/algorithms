package com.algorithms.ik.linkedlists;

public class SwapKthNodes {
    static LinkedListNode swap_nodes(LinkedListNode head, int k) {
        if(head == null) return null;
        LinkedListNode fastPointer = head;
        LinkedListNode nMinusKthNode = head;
        LinkedListNode kthNode = null;
        int i=1;
        while(i<k && fastPointer.next != null){
            fastPointer = fastPointer.next;
            i++;
        }
        kthNode = fastPointer;
        while(fastPointer.next != null){
            fastPointer = fastPointer.next;
            nMinusKthNode = nMinusKthNode.next;
        }
        int temp = kthNode.val;
        kthNode.val = nMinusKthNode.val;
        nMinusKthNode.val = temp;
        return head;
        //System.out.println(kthNode.val);
        //System.out.println(nMinusKthNode.val);
    }

    public static void main(String[] args){
        LinkedListNode node1 = new LinkedListNode();
        node1.val = 1;
        LinkedListNode node2 = new LinkedListNode();
        node2.val = 2;
        LinkedListNode node3 = new LinkedListNode();
        node3.val = 3;
        LinkedListNode node4 = new LinkedListNode();
        node4.val = 4;
        LinkedListNode node7 = new LinkedListNode();
        node7.val = 7;
        LinkedListNode node0 = new LinkedListNode();
        node0.val = 0;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node7;
        node7.next = node0;
        swap_nodes(node1,2);
    }

    //n = 6, L: 1 -> 2 -> 3 -> 4 -> 7 -> 0 -> NULL and k = 2
}
