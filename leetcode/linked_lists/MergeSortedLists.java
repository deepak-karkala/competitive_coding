/*
21. Merge Two Sorted Lists - You are given the heads of two sorted linked lists
 list1 and list2. Merge the two lists in a one sorted list.
The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
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

class MergeSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null, n = null, prev = null;

        while( (list1 != null) && (list2 != null) ) {

            if (list1.val <= list2.val) {
                n = new ListNode(list1.val, null);
                list1 = list1.next;
            } else {
                n = new ListNode(list2.val, null);
                list2 = list2.next;
            }
            
            if (head == null) {
                head = n;
            } else {
                prev.next = n;    
            }
            prev = n;
        }

        while (list1 != null) {
            n = new ListNode(list1.val, null);
            prev.next = n;
            prev = n;
            list1 = list1.next;
        }

        while (list2 != null) {
            n = new ListNode(list2.val, null);
            prev.next = n;
            prev = n;
            list2 = list2.next;
        }

        return head;
    }


    private static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0), prev = head;

        while( (list1 != null) && (list2 != null)) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        if (list1 != null) prev.next = list1;
        if (list2 != null) prev.next = list2;

        return head.next;
    }


    private static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
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
        int[] arr1 = {1, 2, 4};
        ListNode list1 = createSinglyLinkedList(arr1);
        int[] arr2 = {1, 3, 4};
        ListNode list2 = createSinglyLinkedList(arr2);
        ListNode head = mergeTwoListsRecursive(list1, list2);
        printLinkedList(head);
    }
}