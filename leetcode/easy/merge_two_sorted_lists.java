package linked_lists;

/*
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	ListNode l1_prev = l1;
    	ListNode l2_prev = l2;

    	ListNode dummyHead = new ListNode(0);
    	ListNode mergedList = dummyHead;

    	while (l1_prev.next != null && l2_prev.next != null) {
    		if (l1.val <= l2.val) {
    			mergedList.next = l1;
    			l1_prev = l1;
    			l1 = l1.next;
    		} else {
    			mergedList.next = l2;
    			l2_prev = l2;
    			l2 = l2.next;
    		}
    		mergedList = mergedList.next;
    	
	    	printList(mergedList);
	    	printList(dummyHead);

    	}
    	if (l1_prev.next != null) {
    		mergedList.next = l1;
    	}
    	
    	if (l2_prev.next != null) {
    		mergedList.next = l2;
    	}
    	
    	return dummyHead.next;
        
    }
    
    public void printList(ListNode l) {
    	while (l != null) {
    		System.out.print(l.val + "->");
    		l = l.next;
    	}
    	System.out.println("");
    }
    
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    	ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    	
    	Solution sol = new Solution();
    	ListNode mergedList = sol.mergeTwoLists(l1, l2);
    	sol.printList(mergedList);
    	
    }
}