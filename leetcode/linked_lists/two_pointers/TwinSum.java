/*
2130. Maximum Twin Sum of a Linked List
Solved
Medium
Topics
Companies
Hint
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.
*/

class ListNode {
    int val;
    ListNode next, prev;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}


class TwinSum {
	// Get to middle of list
	// Reverse second half of list
	// Find twin sum
	// Time: O(n)
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode curr, prev = null;
        int max = 0;

        // Get to middle of list
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        curr = slow;

        // Reverse second half of list
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Find twin sum
        ListNode first = head, second = prev;
        // prev will be start of reversed list
        while(second != null) {
            max = Math.max(max, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return max;
    }
}