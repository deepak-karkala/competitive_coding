/*
24. Swap Nodes in Pairs
Solved
Medium
Topics
Companies
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes
(i.e., only nodes themselves may be changed.)
Input: head = [1,2,3,4]
Output: [2,1,4,3]
*/

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}  
 
class SwapPairs {
    private static ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) return head;

    	// Swap current and next nodes
    	/*
    	ListNode tmp1 = head;
    	ListNode tmp2 = head.next.next;
    	head.next.next = head;
    	head = head.next;
    	tmp1.next = swapPairs(tmp2);
    	*/

    	ListNode n = head.next;
    	head.next = swapPairs(head.next.next);
    	n.next = head;

        return n;
    }

    public static void main(String[] args) {
    	ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
    	ListNode node = swapPairs(head);
    	while(node != null) {
    		System.out.println(node.val);
    		node = node.next;
    	}
    }
}