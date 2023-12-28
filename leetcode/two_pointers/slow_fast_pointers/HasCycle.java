/*
141. Linked List Cycle
Easy
Topics
Companies
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false
*/

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	  val = x;
	  next = null;
	}
	ListNode(int x, ListNode next) {
	  val = x;
	  next = next;
	}
}

public class HasCycle {
	/*
	Approach: Two pointers, fast and slow pointers
	Time: O(n) Space:O(1)
	*/
    private static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;

        	if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	ListNode tail = new ListNode(-4, null);
    	ListNode pos = new ListNode(2, new ListNode(0, tail));
    	tail.next = pos;
    	ListNode head = new ListNode(3, pos);
    	System.out.println(hasCycle(head));
    }
}