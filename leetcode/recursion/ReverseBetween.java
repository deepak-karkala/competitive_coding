/*
92. Reverse Linked List II
Medium
Topics
Companies
Given the head of a singly linked list and two integers left and right
where left <= right, reverse the nodes of the list from position left to
position right, and return the reversed list
*/

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
} 

class ReverseBetween {

    private static ListNode reverseBetween(ListNode head, int left, int right) {
    	if (head == null || left == right) return head;

    	// Dummy node before head
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
    	ListNode node = preHead;

    	int i;
    	// Move ptr to start of reverse
    	for(i=1; i<left; i++) {
    		node = node.next;
    	}

    	ListNode startPrev = node;	// Node before first node to be reversed
    	ListNode start = node.next;	// First node to be reversed

    	ListNode prev = node;
    	node = node.next;
    	while(i <= right) {
    		ListNode next = node.next;
    		node.next = prev;
    		prev = node;
    		node = next;
    		i++;
    	}

    	startPrev.next = prev;
    	start.next = node;

    	return preHead.next;

    }

    public static void main(String[] args) {
    	//ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
    	ListNode head = new ListNode(3, new ListNode(5, null));
    	int left = 1, right = 2;
    	ListNode node = reverseBetween(head, left, right);
    	while(node != null) {
    		System.out.println(node.val);
    		node = node.next;
    	}
    }
}