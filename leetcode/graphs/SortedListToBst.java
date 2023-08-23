/*
109. Convert Sorted List to Binary Search Tree
Medium
7.1K
150
Companies
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
height-balanced
 binary search tree.
 */

import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
}


class SortedListToBst {
	private static ListNode node;
    private static TreeNode sortedListToBST(ListNode head) {
    	int size = 0;
    	ListNode runner = head;
    	node = head;
    	while(runner != null) {
    		runner = runner.next;
    		size++;
    	}
        return sortedListToBST_inorder(0, size-1);
    }

    private static TreeNode sortedListToBST_inorder(int start, int end) {
    	if (start > end) return null;

    	int mid = start + (end - start)/2;

    	// Build left sub-tree
    	TreeNode left = sortedListToBST_inorder(start, mid-1);

    	// Assign root
    	TreeNode root = new TreeNode(node.val);
    	root.left = left;
    	node = node.next;

    	// Build right sub-tree
    	TreeNode right = sortedListToBST_inorder(mid+1, end);
    	root.right = right;

    	return root;
    }

    public static void main(String[] args) {
    	ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
    	TreeNode root = sortedListToBST(head);
    }
}