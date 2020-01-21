package com.algorithms.ik.linkedlists;

public class AlternativeNodeSplit {
    static LinkedListNode[] alternativeSplit(LinkedListNode head){
        if(head == null) return new LinkedListNode[2];
        LinkedListNode pointer1 = head;
        LinkedListNode head2 = null;
        LinkedListNode pointer2 = null;
        while(pointer1 != null && pointer1.next != null){
            LinkedListNode alternateNode = pointer1.next;
            pointer1.next = alternateNode.next;
            pointer1 = alternateNode.next;
            if(pointer2 == null){
                pointer2 = alternateNode;
                head2 = pointer2;
            }else{
                pointer2.next = alternateNode;
                pointer2 = pointer2.next;
            }
            alternateNode.next = null;
        }
        LinkedListNode[] nodeList = new LinkedListNode[2];
        nodeList[0] = head;
        nodeList[1] = head2;
        return nodeList;
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
        //LinkedListNode node6 = new LinkedListNode();
        //node6.val = 6;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node6;

        LinkedListNode[] nodeList = alternativeSplit(node1);

        LinkedListNode list1 = nodeList[0];
        while(list1 != null){
            System.out.println(list1.val);
            list1 = list1.next;
        }

        LinkedListNode list2 = nodeList[1];
        while(list2 != null){
            System.out.println(list2.val);
            list2 = list2.next;
        }
    }
}
