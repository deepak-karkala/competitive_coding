/*
23. Merge k Sorted Lists
Solved
Hard
Topics
Companies
You are given an array of k linked-lists lists, each linked-list is
sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
*/

import java.util.*;

class ListNode {
    int val;
    ListNode next, prev;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}


class MergeKLists {
	/* Min Heap to store smallest element of each k lists */
    private static ListNode mergeKLists(ListNode[] lists) {
    	// First element: value Second element: list Id
    	PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    	ListNode ptr = new ListNode();
    	ListNode head = ptr;

    	// Add smallest (first since each list is sorted) element
    	for(int i=0; i<lists.length; i++) {
    		if (lists[i] != null) {
    			queue.offer(new int[] {lists[i].val, i});
    			lists[i] = lists[i].next;
    		}
    	}

    	// Iterate till queue is empty (all nodes are in sorted list)
    	while (!queue.isEmpty()) {
    		int[] smallest = queue.poll();

    		ptr.next = new ListNode(smallest[0]);
    		ptr = ptr.next;

    		// Add the next smallest element from this list
    		int listId = smallest[1];
    		if (lists[listId] != null) {
    			queue.offer(new int[] {lists[listId].val, listId});
    			lists[listId] = lists[listId].next;
    		}
    	}
    	return head.next;
    }

    public static void main(String[] args) {
    	ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    	ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    	ListNode list3 = new ListNode(2, new ListNode(6));

    	ListNode[] lists = new ListNode[3];
    	lists[0] = list1; lists[1] = list2; lists[2] = list3;

    	ListNode node = mergeKLists(lists);
    	while(node != null) {
    		System.out.println(node.val);
    		node = node.next;
    	}
    }
}