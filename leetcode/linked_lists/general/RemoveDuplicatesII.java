/*
82. Remove Duplicates from Sorted List II
Solved
Medium
Topics
Companies
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
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

class RemoveDuplicatesII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null) {
            while (curr.next != null && curr.next.val == curr.val) curr = curr.next;
            if (prev.next == curr) prev = prev.next;
            else prev.next = curr.next;
            curr = curr.next;    
        }
        return dummy.next;
    }
}