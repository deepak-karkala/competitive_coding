package linked_lists;

/*
 * Given a linked list and a value x, partition it such that all nodes 
 * less than x come before nodes greater than or equal to x. You should
 * preserve the original relative order of the nodes in each of the two partitions.
 * 	Input: head = 1->4->3->2->5->2, x = 3
	Output: 1->2->2->4->3->5
 */

/**
 * Definition for singly-linked list.
 * */
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 

class PartitionList {
    public ListNode partition(ListNode head, int x) {
        
    	// Initialize two lists
    	ListNode smallerListHead = new ListNode();
    	ListNode smallerListRunner = new ListNode();
    	ListNode biggerListRunner = new ListNode();
    	ListNode biggerListHead = new ListNode(); 
    	
    	// Traverse the list
    	// If n.val < x, addLast to smallerList, else to biggerLast
    	ListNode node = head;
    	while (node != null) {
    		ListNode next = node.next;
    		node.next = null;
    		
    		if (node.val >= x) {
    			biggerListRunner.next = node;
    			if (biggerListHead.next == null) {
    				biggerListHead = biggerListRunner;
    			}
    			biggerListRunner = biggerListRunner.next;
    		} else {
    			smallerListRunner.next = node;
    			if (smallerListHead.next == null) {
    				smallerListHead = smallerListRunner;
    			}
    			smallerListRunner = smallerListRunner.next;
    		}
    		
    		
    		//System.out.print(node.val + "->");
    		node = next;

    		//printList(biggerListHead);
    	}
    	
    	
    	if (smallerListHead.next == null) {
    		return biggerListHead.next;
    	}
    	// Set smallerList's last node.next to biggerLast.head
    	// Return smallerList.head
    	smallerListRunner.next = biggerListHead.next;
    	
    	return smallerListHead.next;
    }
    
    public static void printList(ListNode l) {
    	while (l != null) {
    		System.out.print(l.val + "->");
    		l = l.next;
    	}
    	System.out.println("");
    }

    public static void main(String[] args) {
    	//ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)) ))));
    	ListNode l1 = new ListNode(1);
    	int pivot = 0;
    	PartitionList sol = new PartitionList();
    	ListNode partitionedList = sol.partition(l1, pivot);
    	printList(partitionedList);
    }
}
