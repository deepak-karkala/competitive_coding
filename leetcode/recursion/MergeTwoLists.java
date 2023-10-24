/*
21. Merge Two Sorted Lists
Solved
Easy
Topics
Companies
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by
splicing together the nodes of the first two lists.

Return the head of the merged linked list.
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

class MergeTwoLists {
	/* Iterative */
    private static ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(0);
        ListNode head = pre;

        while(list1 != null && list2 != null) {
        	if (list1.val <= list2.val) {
        		pre.next = list1;
        		list1 = list1.next;
        	} else {
        		pre.next = list2;
        		list2 = list2.next;
        	}
        	pre = pre.next;
        }

        if (list1 != null) pre.next = list1;
        if (list2 != null) pre.next = list2;

        return head.next;
    }

    /* Recursive */
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

    public static void main(String[] args) {
    	ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    	ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    	ListNode node = mergeTwoListsRecursive(list1, list2);
    	while(node != null) {
    		System.out.println(node.val);
    		node = node.next;
    	}
    }
}