package com.algorithms.leetcode.trees;

import com.algorithms.leetcode.linkedlists.ListNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        TreeNode root = construct(head);
        return root;
    }

    private TreeNode construct(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        ListNode previous = null;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            previous = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if(previous != null){
            previous.next = null;
            root.left = construct(node);
        }
        if(slow.next != null){
            root.right = construct(slow.next);
        }
        return root;
    }
}
