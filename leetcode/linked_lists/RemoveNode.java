/*
19. Remove Nth Node From End of List
Solved
Medium
Topics
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.
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
        ptr.next = ptr.next.next;
        return dummyHead.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead, fast = dummyHead;

        int listlen = 0, nodeCounter = 0;
        while((fast.next != null) && (fast.next.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            nodeCounter++;
        }
        // Find listlen
        listlen = (fast.next == null) ? nodeCounter*2 : nodeCounter*2+1;
        
        // Delete node (update next of previous node)
        slow = dummyHead;
        nodeCounter = 0;
        while(nodeCounter < (listlen - n)) {
            slow = slow.next;
            nodeCounter++;
        }

        slow.next = slow.next.next;
        return dummyHead.next;
    }

    public static ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead, fast = dummyHead;

        // Move fast to n ahead of slow
        for(int i=0; i<n; i++) fast = fast.next;

        // Move both fast and slow by one, until fast reaches end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // At this point, slow is at N-nth node, which is to be removed
        slow.next = slow.next.next;

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
        int[] arr = {1};
        ListNode list = createSinglyLinkedList(arr);
        ListNode head = removeNthFromEndOnePass(list, 1);
        printLinkedList(head);
    }
}