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
        ListNode head = mergeTwoLists(list1, list2);
        printLinkedList(head);
    }
}