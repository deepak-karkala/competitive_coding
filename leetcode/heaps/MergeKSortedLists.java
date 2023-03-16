/*
23. Merge k Sorted Lists
Hard
16.6K
606
Companies
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
*/

import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {

	private static ListNode mergeKSortedLists(ListNode[] lists) {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		ListNode ptr = new ListNode();
		ListNode sortedListHead = new ListNode();

		// Init queue with first elements of each list (since they are already sorted)
		for (int i=0; i<lists.length; i++) {
			if (lists[i] != null) {
				q.offer(new int[] {lists[i].val, i});
				lists[i] = lists[i].next;
			}
		}

		// Keep iterating until q is empty
		sortedListHead = ptr;
		while(!q.isEmpty()) {
			// Get smallest element and add it to sorted list
			int[] smallest = q.poll();
			ptr.next = new ListNode(smallest[0], null);
			ptr = ptr.next;

			// Add the next element from the list from which last element was polled
			int listId = smallest[1];
			if (lists[listId] != null) {
				q.offer(new int[]{ lists[listId].val, listId});
				lists[listId] = lists[listId].next;
			}
		}

		return sortedListHead.next;
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

    public ListNode lcSolution1(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

	public static void main(String[] args) {

		int[] arr1 = {1, 4, 5};
        ListNode l1 = createSinglyLinkedList(arr1);
        int[] arr2 = {1, 3, 4};
        ListNode l2 = createSinglyLinkedList(arr2);
        int[] arr3 = {2, 6};
        ListNode l3 = createSinglyLinkedList(arr3);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

		ListNode list = mergeKSortedLists(lists);
		printLinkedList(list);
	}
}