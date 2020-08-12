package linked_lists;

class PartitionList {
    public ListNode partition(ListNode head, int x) {
        
    	// Initialize two lists
    	ListNode smallerList = new ListNode();
    	ListNode biggerList = new ListNode();
    	
    	// Traverse the list
    	// If n.val < x, addLast to smallerList, else to biggerLast
    	ListNode n = head;
    	while (n.next != null) {
    		if (n.val >= x) {
    			biggerList.next = n;
    			biggerList = biggerList.next;
    		} else {
    			smallerList.next = n;
    			smallerList = smallerList.next;
    		}
    		n = n.next;
    	}
    	
    	
    	// Set smallerList's last node.next to biggerLast.head
    	// Return smallerList.head
    	smallerList.next = 
    }
}