/*
160. Intersection of Two Linked Lists
Solved
Easy
Topics
Companies
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
*/

public class GetIntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while(a != b) {
            a = a==null ? headB : a.next;
            b = b==null ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = getListLen(headA);
        int lenB = getListLen(headB);

        while(lenA != lenB) {
            if (lenA > lenB) {headA = headA.next; lenA--;}
            else {headB = headB.next; lenB--;}
        }

        while(headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int getListLen(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}