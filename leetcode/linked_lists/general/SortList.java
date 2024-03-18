/*
148. Sort List
Solved
Medium
Topics
Companies
Given the head of a linked list, return the list after sorting it in ascending order.
*/

class SortList {
    // Find middle and split the list into two for merge sort
    // Time: O(nlogn) Space: logn for recursive calls
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(left != null && right != null) {
            if (left.val <= right.val) {curr.next = left; left = left.next;}
            else {curr.next = right; right = right.next;}
            curr = curr.next;
        }
        if (left != null) curr.next = left;
        if (right != null) curr.next = right;
        return dummy.next;
    }

}