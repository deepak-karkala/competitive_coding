/*
206. Reverse Linked List
Easy
Topics
Companies
Given the head of a singly linked list, reverse the list, and return the reversed list
*/

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
} 

class ReverseList {
	/* Recursive */
    private static ListNode reverseListRecursive(ListNode head) {
    	return reverse(head, null);
    }

    private static ListNode reverse(ListNode node, ListNode newNext) {
    	if (node == null) return newNext;
    	ListNode next = node.next;
    	node.next = newNext;
    	return reverse(next, node);
    }

    /* Iterative */
    private static ListNode reverseListIterative(ListNode head) {
    	ListNode prev = null;
    	while(head != null) {
    		ListNode next = head.next;
    		head.next = prev;
    		prev = head;
    		head = next;
    	}
    	return prev;
    }

    public static void main(String[] args) {
    	ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    	//ListNode head = new ListNode(1, null);
    	ListNode node = reverseListIterative(head);
    	while(node != null) {
    		System.out.println(node.val);
    		node = node.next;
    	}
    }
}