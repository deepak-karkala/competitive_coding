/*
61. Rotate List
Medium
7.1K
1.3K
Given the head of a linked list, rotate the list to the right by k places.
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

public class RotateList {
    
    /*
    Rotation by k - what is happening in example ?
		k = 1: (n-1)th node.next = null, nth.next = head, head = n
		k = 2: (n-2)th node.next = null, nth.next = head, head = n-1
		k = 3: (n-3)th node.next = null, nth.next = head, head = n-2
		…
		k = n-1: (1)st node.next = null, nth.next = head, head = n-(n-2)th node
		k = 0(n):  nth node.next = null,                  head = 0
	If k==0 or k==n, return head (same list, no change). If not,
	Identify n-kth node (slow, fast runner)
	Set n-kth node.next = null, nth.next = head, head = (n-k-1)th node
    */
    public static ListNode rotateList(ListNode head, int k) {
    	if ((head==null) || (k==0)) return head;
        ListNode slow = head, fast = head;

        // Find length
        int listlen = 0;
        while(fast != null) {
        	fast = fast.next;
        	listlen++;
        }
        k = k % listlen;
        if (k==0) return head;

        // Find (n-k)th node
        // Slow and fast runner approach, single pass
        fast = head;
        int i = 1;
        while(i<=k) {
        	fast = fast.next;
        	i++;
        }
        while(fast.next != null) {
        	slow = slow.next;
        	fast = fast.next;
        	i++;
        }

        // Fast is now at nth node
        fast.next = head;
        // Update head to (n-k-1)th node
        head = slow.next;
        // Slow is now at (n-k)th node
        slow.next = null;

        return head;
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
        int[] arr = {0, 1, 2};
        ListNode list = createSinglyLinkedList(arr);
        ListNode head = rotateList(list, 4);
        printLinkedList(head);
    }
}