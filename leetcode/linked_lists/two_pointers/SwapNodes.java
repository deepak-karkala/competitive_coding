/*
1721. Swapping Nodes in a Linked List
Solved
Medium
Topics
Companies
Hint
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
*/


class SwapNodes {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode kEnd = head, curr = head, kStart = start;

        // Get to kth node from start and from end
        for(int i=1; i<=k; i++) {curr = curr.next; kStart = kStart.next;}
        while (curr != null) {
            kEnd = kEnd.next;
            curr = curr.next;
        }

        int kStartVal = kStart.val;
        kStart.val = kEnd.val;
        kEnd.val = kStartVal;

        return start.next;
    }

    public ListNode swapNodes2(ListNode head, int k) {
        /// Find length of linked list
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

    	int tmp = n2.val;
    	n2.val = n1.val;
    	n1.val = tmp;

        return head;
    }
}