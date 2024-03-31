/*
25. Reverse Nodes in k-Group
Solved
Hard
Topics
Companies
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
*/

class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;

        int nodeCount = 0;
        // Call reverse after every k nodes
        while(head != null) {
            nodeCount++;

            if (nodeCount % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;  // Start of next reverse group
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start.next, prev = start, next, first;
        first = curr;

        while(curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        start.next = prev;
        first.next = curr;
        return first;
    }

    public ListNode reverseKGroupRecursive(ListNode head, int k) {
	    ListNode curr = head;
	    int count = 0;
	    while (curr != null && count != k) { // find the k+1 node
	        curr = curr.next;
	        count++;
	    }
	    if (count == k) { // if k+1 node is found
	        curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
	        // head - head-pointer to direct part, 
	        // curr - head-pointer to reversed part;
	        while (count-- > 0) { // reverse current k-group: 
	            ListNode tmp = head.next; // tmp - next head in direct part
	            head.next = curr; // preappending "direct" head to the reversed list 
	            curr = head; // move head of reversed part to a new node
	            head = tmp; // move "direct" head to the next node in direct part
	        }
	        head = curr;
	    }
	    return head;
	}
}