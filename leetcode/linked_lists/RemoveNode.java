/*
142. Linked List Cycle II
Medium
10.1K
736
Given the head of a linked list, return the node where the cycle begins.
If there is no cycle, return null.
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

public class RemoveNode {
    // Baseline - two pass
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode ptr = head;
        // Find length of list
        int listlen = 0;
        while (ptr != null) {
            ptr = ptr.next;
            listlen += 1;
        }

        // Move to node behind the one to be deleted        
        ListNode dummyHead = new ListNode(0, head);
        ptr = dummyHead;
        int i = 0;
        while (i < (listlen - n)) {
            ptr = ptr.next;
            i++;
        }

        // Delete node (update next of previous node)
        if (ptr.next != null) {
            ptr.next = ptr.next.next;
        } else {
            ptr.next = null;
        }
        return dummyHead.next;
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
        int[] arr = {1, 2, 3, 4, 5};
        ListNode list = createSinglyLinkedList(arr);
        ListNode head = removeNthFromEnd1(list, 2);
        printLinkedList(head);
    }
}