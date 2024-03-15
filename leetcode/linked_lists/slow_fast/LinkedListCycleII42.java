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

public class LinkedListCycleII42 {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        // No cycle found
        if ((fast==null) || (fast.next==null)) return null;

        // Detect node where cycle starts
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static ListNode createSinglyLinkedListWithCycle(int[] arr, int pos) {
        ListNode head = null, next = null, prev = null, cycleStartNode = null;
        for(int i=0; i<arr.length; i++) {
            ListNode n = new ListNode(arr[i], next);
            if (i!=0) {
                prev.next = n;
            } else {
                head = n;
            }
            prev = n;

            if (i==pos) cycleStartNode = n;
        }
        prev.next = cycleStartNode;
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
        int[] arr1 = {1,2};
        ListNode list1 = createSinglyLinkedListWithCycle(arr1, 0);
        ListNode cycleStartNode = detectCycle(list1);
        System.out.println(cycleStartNode.val);
    }
}