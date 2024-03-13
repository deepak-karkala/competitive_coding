/*
203. Remove Linked List Elements
Solved
Easy
Topics
Companies
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
*/

class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while(curr != null) {
            ListNode next = curr.next;
            while (next != null && next.val == val) next = next.next;
            curr.next = next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode removeElementsRecursive(ListNode head, int val) {
       if (head == null) return head;
       head.next = removeElementsRecursive(head.next, val);
       return head.val == val ? head.next : head;
    }
}