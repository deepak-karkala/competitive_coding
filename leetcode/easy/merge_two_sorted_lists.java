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
    	
    	ListNode mergedList = new ListNode();
    	while (l1.next != null && l2.next != null) {
    		if (l1.val <= l2.val) {
    			mergedList.next = l1;
    			l1 = l1.next;
    		} else {
    			mergedList.next = l2;
    			l2 = l2.next;
    		}
    		printList(mergedList);
    	}
    	
    	if (l1.next != null) {
    		mergedList.next = l1;
    	}
    	
    	if (l2.next != null) {
    		mergedList.next = l2;
    	}
    	
    	return mergedList;
        
    }
    
    public void printList(ListNode l) {
    	while (l != null) {
    		System.out.print(l.val + "->");
    		l = l.next;
    	}
    }
    
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    	ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    	
    	Solution sol = new Solution();
    	ListNode mergedList = sol.mergeTwoLists(l1, l2);
    	ListNode l = mergedList;
    	while (l != null) {
    		System.out.println(l.val + "->");
    		l = l.next;
    	}
    }
}