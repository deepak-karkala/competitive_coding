/*
147. Insertion Sort List
Solved
Medium
Topics
Companies
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
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

class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy, curr = head, temp = null;

        while(curr != null) {
            temp = curr.next;

            /* Before insert, the prev is at the last node of the sorted list.
                Only the last node's value is larger than the current inserting node 
                should we move the temp back to the head
            */
            if (prev.val >= curr.val) prev = dummy;

            // Find correct position for current node
            //      Between prev and prev.next
            while (prev.next!=null && prev.next.val < curr.val) prev = prev.next;

            curr.next = prev.next;
            prev.next = curr;
            curr = temp;
        }
        return dummy.next;
    }
}