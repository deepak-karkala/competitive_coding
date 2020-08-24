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
	
	// Approach 1: Reverse and compare
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
    
    
    // Approach 2: Recurse
    public boolean isPalindromeRecurse(ListNode head) {
    	// Get length
    	int length = getLength(head);
    	// Recurse, each time compare ith and length-ith elements
    	// Return next node and comparison boolean result
    	Result result = recurse(head, length);
    	return result.isPalindrome;
    }
    
    public int getLength(ListNode head) {
    	int length = 0;
    	while (head != null) {
    		length++;
    		head = head.next;
    	}
    	return length;
    }
    
    
    public Result recurse(ListNode node, int length) {
    	// Base case
    	if (node==null || length==0) {
    		return new Result(node, true);
    	} else if (length==1) {
    		return new Result(node.next, true);
    	}
    	
    	// Recursive call
    	Result result = recurse(node.next, length-2);
    	
    	if (result.isPalindrome == false) {
    		return new Result(node.next, false);
    	}
    	
    	result.isPalindrome =  (node.val == result.next.val);
    	result.next = result.next.next;
    	
    	return result;
    }
    
    class Result {
    	ListNode next;
    	boolean isPalindrome;
    	Result(ListNode next, boolean isPalindrome) {
    		this.next = next;
    		this.isPalindrome = isPalindrome;
    	}
    }
    
    static void printList(ListNode head) {
    	while (head != null) {
    		System.out.print(head.val + "->");
    		head = head.next;
    	}
    	System.out.println("");
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
    	printList(head);
    	IsLinkedListPalindrome sol = new IsLinkedListPalindrome();
    	
    	// Reverse and Compare
    	//System.out.print(sol.isPalindrome(head));
    	// Recurse
    	System.out.print(sol.isPalindromeRecurse(head));
    }
    
}