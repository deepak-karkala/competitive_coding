/*
148. Sort List
Medium
Topics
Companies
Given the head of a linked list, return the list after sorting it in ascending order
*/

import java.util.*;

class ListNode {
    int val;
    ListNode next, prev;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}


class SortList {
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Split the list into two parts (two pointers)
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
        	prev = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        // Terminate the first half of list
        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // Merge the left and right halves
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
    	ListNode curr = new ListNode(0);
    	ListNode prev = curr;

    	while (left != null && right != null) {
    		if (left.val <= right.val) {
    			curr.next = left;
    			left = left.next;
    		} else {
    			curr.next = right;
    			right = right.next;
    		}
    		curr = curr.next;
    	}

    	if (left != null) curr.next = left;
    	if (right != null) curr.next = right;

    	return prev.next;
    }

    public static void main(String[] args) {
    	ListNode list = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
    	ListNode sorted = sortList(list);
    	while(sorted != null) {
    		System.out.print(sorted.val + "-->");
    		sorted = sorted.next;
    	}
    	System.out.println("");
    }
}