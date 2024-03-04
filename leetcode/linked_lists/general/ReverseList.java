/*
206. Reverse Linked List
Solved
Easy
Topics
Companies
Given the head of a singly linked list, reverse the list, and return the reversed list.
*/

class ReverseList {

    // Iterative
    public ListNode reverseListIterative(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, curr = head, next = curr.next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}