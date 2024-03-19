/*
24. Swap Nodes in Pairs
Solved
Medium
Topics
Companies
Given a linked list, swap every two adjacent nodes and return its head. 
You must solve the problem without modifying the values in the list's nodes 
(i.e., only nodes themselves may be changed.)
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

public class SwapNode {
    // Baseline
    public static ListNode swapNode(ListNode head) {
        ListNode curr = head, next;
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode newHead = prev;

        while((curr != null) && (curr.next != null)) {
            next = curr.next;

            curr.next = next.next;
            next.next = curr;
            prev.next = next;

            prev = curr;
            curr = curr.next;
        }

        return newHead.next;
    }


    public static ListNode swapNodeRecursive(ListNode head) {
        // Base case
        if ( (head==null) || (head.next==null)) return head;

        ListNode next = head.next;
        head.next = swapNodeRecursive(head.next.next);
        next.next = head;
        return next;
    }


    private static ListNode createSinglyLinkedList(int[] arr) {
        ListNode head = null, next = null, prev = null;
        for(int i=0; i<arr.length; i++) {
            ListNode n = new ListNode(arr[i], next);
            if (i!=0) {
                prev.next = n;
            } else {
                head = n;
            }
            prev = n;
        }
        return head;
    }

    private static void printLinkedList(ListNode head) {
        ListNode ptr = head;
        while(ptr != null) {
            System.out.print(ptr.val + "-->");
            ptr = ptr.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode list = createSinglyLinkedList(arr);
        ListNode head = swapNodeRecursive(list);
        printLinkedList(head);
    }
}