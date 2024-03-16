/*
234. Palindrome Linked List
Solved
Easy
Topics
Companies
Given the head of a singly linked list, return true if it is a 
palindrome or false otherwise.
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

class PalindromeList {
    /*
    Reverse second half of list, only way to check palindrome in place
    Time: O(n) Space:O(1)
    1. Get to middle of list (slow, fast)
    2. Reverse second half
    3. Traverse and compare two lists
    */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, next;
        // Get to middle of list
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Set start (end of reversed) second half to null
        prev = slow;
        slow = slow.next;
        prev.next = null;

        // Reverse the list
        while(slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Compare first half with reversed second half
        fast = head;
        slow = prev;
        while(slow != null) {
            if (fast.val != slow.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
}