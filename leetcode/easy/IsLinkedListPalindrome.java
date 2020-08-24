package linked_lists;
/*
 * Given a singly linked list, determine if it is a palindrome.
*/

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class IsLinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
    	// Reverse (and copy to new) linked list
    	ListNode reversed = getReversed(head);
    	
    	// Traverse and compare original and reversed
    	// Return true if original and reversed match until end of lists
    	return isEqual(head, reversed);
    }
    
    ListNode getReversed(ListNode head) {
    	if (head == null) {
    		return null;
    	}

    	//ListNode reversedHead = new ListNode(head.val);
    	ListNode prev = null;

    	while (head != null) {
    		ListNode reversedNode = new ListNode(head.val);
    		reversedNode.next = prev;
    		prev = reversedNode;
    		head = head.next;
    	}
    	
    	return prev;
    }
    
    boolean isEqual(ListNode l1, ListNode l2) {
    	while (l1 != null && l2 != null) {
    		if (l1.val != l2.val) {
    			return false;
    		}
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	return true;
    }
    
    static void printList(ListNode head) {
    	while (head != null) {
    		System.out.print(head.val + "->");
    		head = head.next;
    	}
    	System.out.println("");
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
    	printList(head);
    	IsLinkedListPalindrome sol = new IsLinkedListPalindrome();
    	ListNode reversed = sol.getReversed(head);
    	printList(reversed);
    	boolean result = sol.isEqual(head, reversed);
    	System.out.print(result);
    }
    
}