/*
1290. Convert Binary Number in a Linked List to Integer
Solved
Easy
Topics
Companies
Hint
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

The most significant bit is at the head of the linked list.
*/

class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        int len = 0, val = 0;
        ListNode curr = head;
        while(curr != null) {len++; curr = curr.next;}

        curr = head;
        while(curr != null) {
            val += curr.val * Math.pow(2, --len);
            curr = curr.next;
        }
        return val;
    }
}