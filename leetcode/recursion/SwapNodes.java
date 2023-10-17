/*
1721. Swapping Nodes in a Linked List
Medium
Topics
Companies
Hint
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node
from the beginning and the kth node from the end (the list is 1-indexed).
*/

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}  

class SwapNodes {
    private static ListNode swapNodes(ListNode head, int k) {
    	// Find length of linked list
    	ListNode n1 = head;
    	int len = 0;
    	while(n1 != null) {
    		n1 = n1.next;
    		len++;
    	}
    	// Set n1 to kth node from beginning
    	n1 = head;
    	int counter = 0;
    	while(counter < k-1) {
    		n1 = n1.next;
    		counter++;
    	}

    	// Set n2 to kth node from end = (len-k)th node from beginning
    	ListNode n2 = head;
    	counter = 0;
    	while(counter < len-k) {
    		n2 = n2.next;
    		counter++;
    	}

    	int tmp = n2.val;
    	n2.val = n1.val;
    	n1.val = tmp;

        return head;
    }


    /*
    Approach - Linked list navigation with two pointers Optimised
    1. Move k steps, set n1 to this node (kth from start)
    2. Continue iterating,
    	a. start incrementing n2 now,
    	b. When ptr reaches end, n2 points at (n-k)th node
    */
    private static ListNode swapNodes2(ListNode head, int k) {
    	// Find length of linked list
    	ListNode n1 = head;
    	ListNode n2 = head;
    	ListNode ptr = head;

    	int counter = 1;
    	while(ptr.next != null) {
    		ptr = ptr.next;
    		if (counter++ < k) {
    			n1 = n1.next;
    		} else {
    			n2 = n2.next;
    		}
    	}

		System.out.println(n1.val + "--" + n2.val);    	

    	int tmp = n2.val;
    	n2.val = n1.val;
    	n1.val = tmp;

        return head;
    }

    public static void main(String[] args) {
    	ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    	//ListNode head = new ListNode(1, null);
    	int k = 2;
    	ListNode node = swapNodes2(head, k);
    	while(node != null) {
    		System.out.println(node.val);
    		node = node.next;
    	}
    }
}