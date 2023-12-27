/*
160. Intersection of Two Linked Lists
Easy
Topics
Companies
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null
*/

/**
 * Definition for singly-linked list.
 */
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	  val = x;
	  next = null;
	}
}

public class GetIntersectionNode {
	/*
	1. Get length of both
	2. Move the head of longer list to counteract the len difference
	3. Compare if they intersect
	*/
    private static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    	int lenA = getLength(headA);
    	int lenB = getLength(headB);

    	while(lenA > lenB) {
    		headA = headA.next;
    		lenA--;
    	}

    	while(lenB > lenA) {
    		headB = headB.next;
    		lenB--;
    	}

    	while(headA != headB) {
    		headA = headA.next;
    		headB = headB.next;
    	}
        return headA;
    }

    private static int getLength(ListNode head) {
    	int len = 0;
    	while(head != null) {
    		head = head.next;
    		len++;
    	}
    	return len;
    }

    /*
    1. Keep comparing the two heads
    2. If both reach null at the same time without intersecting, return null (same len, no intersect)
    3. If any of the head reaches null, set it to head of other, continue comparing
    	This will counteract the differene in length
    4. If they intersect, they will meet
    */
    private static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    	ListNode a = headA;
    	ListNode b = headB;

        while(a != b) {
        	if (a == null) a = headB;
        	else a = a.next;

        	if (b == null) b = headA;
        	else b = b.next;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}