package com.algorithms.ik.linkedlists;


/**
 * TODO: INCOMPLETE
 */
public class ZipGivenLinkedListFromEnds {

    static LinkedListNode zip_given_linked_list(LinkedListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        LinkedListNode fastPointer = head;
        LinkedListNode slowPointer = head;
        while(fastPointer.next != null && fastPointer.next.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        LinkedListNode list2 = slowPointer.next;
        slowPointer.next = null;
        LinkedListNode reverseList2 = reverseList(list2);
        return mergeLists(head, reverseList2);
    }

    private static LinkedListNode reverseList(LinkedListNode head){
        LinkedListNode newHead = null;
        while(head != null){
            LinkedListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    private static LinkedListNode mergeLists(LinkedListNode list1, LinkedListNode list2){
        LinkedListNode toReturn = list1;
        while(list2 != null){
            LinkedListNode temp1 = list1.next;
            LinkedListNode temp2 = list2;
            list2 = list2.next;
            list1.next = temp2;
            temp2.next = temp1;
            list1 = list1.next.next;
        }
        return toReturn;
    }

    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode();
        node1.val = 1;
        LinkedListNode node2 = new LinkedListNode();
        node2.val = 2;
        LinkedListNode node3 = new LinkedListNode();
        node3.val = 3;
        LinkedListNode node4 = new LinkedListNode();
        node4.val = 4;
        LinkedListNode node5 = new LinkedListNode();
        node5.val = 5;
        LinkedListNode node6 = new LinkedListNode();
        node6.val = 6;
        LinkedListNode node7 = new LinkedListNode();
        node7.val = 7;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        LinkedListNode zippedList = zip_given_linked_list(node1);
        while(zippedList != null){
            System.out.println(zippedList.val);
            zippedList = zippedList.next;
        }
    }

}

/*
For input n = 6 and L: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL, output will be:

1

6

2

5

3

4
 */
