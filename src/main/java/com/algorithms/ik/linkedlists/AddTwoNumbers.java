package com.algorithms.ik.linkedlists;

public class AddTwoNumbers {

    public static SinglyLinkedListNode addTwoNumbers(SinglyLinkedListNode l_a, SinglyLinkedListNode l_b) {

        SinglyLinkedListNode pointerA = l_a;
        SinglyLinkedListNode pointerB = l_b;
        SinglyLinkedListNode pointerC = null;
        SinglyLinkedListNode pointerCHead = null;
        int carryForward = 0;
        while(pointerA != null || pointerB != null){
            int sum = 0;
            if(pointerA != null){
                sum = sum + pointerA.data;
                pointerA = pointerA.next;
            }
            if(pointerB != null){
                sum = sum + pointerB.data;
                pointerB = pointerB.next;
            }
            sum = sum + carryForward;
            int newNodeValue = sum%10;
            if(pointerC == null){
                pointerC = new SinglyLinkedListNode(newNodeValue);
                pointerCHead = pointerC;
            }else{
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(newNodeValue);
                pointerC.next = newNode;
                pointerC = pointerC.next;
            }
            carryForward = sum/10;
        }
        if(carryForward > 0){
            while(carryForward != 0){
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(carryForward%10);
                pointerC.next = newNode;
                pointerC = pointerC.next;
                carryForward = carryForward/10;
            }
        }
        return pointerCHead;
    }

    public static void main(String[] args){
        SinglyLinkedListNode node11 = new SinglyLinkedListNode(9);
        SinglyLinkedListNode node12 = new SinglyLinkedListNode(9);
        SinglyLinkedListNode node13 = new SinglyLinkedListNode(9);
        node11.next = node12;
        node12.next = node13;

        SinglyLinkedListNode node21 = new SinglyLinkedListNode(9);
        SinglyLinkedListNode node22 = new SinglyLinkedListNode(9);
        SinglyLinkedListNode node23 = new SinglyLinkedListNode(9);
        node21.next = node22;
        node22.next = node23;

        SinglyLinkedListNode node = addTwoNumbers(node11, node21);
        while(node != null){
            System.out.print(node.data);
            node = node.next;
        }
    }

}
