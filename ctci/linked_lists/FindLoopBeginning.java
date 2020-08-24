package linked_lists;

/*
 * Loop Detection: Given a circular linked list, implement an algorithm
 * that returns the node at the beginning of the loop.
	DEFINITION: Circular linked list: A (corrupt) linked list in which
	a node's next pointer points to an earlier node, so as to make a loop
	in the linked list.
	
	EXAMPLE
	Input: A -> B -> C -> D -> E -> C [the same C as earlier] Output: C
 */

class ListNode {
	int val;
	ListNode next;
	
	ListNode() {
		
	}
	
	ListNode(int val) {
		this.val = val;
	}
	
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	
}




class FindLoopBeginning {
	
	ListNode findLoopBeginning(ListNode head) {
		/*
		 * Size of non-looped part: k
		 * When slowRunner enters loop (After k steps) => fastRunner: 2k steps
		 * fastRunner k (k mod loop_size) steps inside loop
		 * => fastRunner: k steps ahead of slowRunner
		 * => fastRunner: loopSize-k steps behind slowRunner
		 * => Will collide after loopsize-k steps (from the point when slowRunner
		 * enters loop) 
		 * => will collide k nodes before head of the loop 
		*/

		//Initialise slowRunner and fastRunner to Linkedlist head
		ListNode slow = head;
		ListNode fast = head;
		
		//Traverse slowRunner and fastRunner until they collide
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		
		// if no loop fast will be at null return null
		if (fast == null || fast.next == null) {
			return null;
		}

		//When they collide, move slowRunner to head,
		//increment both by 1 step for k nodes to reach beginning of loop
		slow = head;
		while (slow != fast ) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
		
	}
	
	static void printNode(ListNode node) {
		/*
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		*/
		System.out.print(node.val);
		
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode('A');
		ListNode b = new ListNode('B');
		a.next = b;
		ListNode c = new ListNode('C');
		b.next = c;
		ListNode d = new ListNode('D');
		c.next = d; 
		ListNode e = new ListNode('E');
		d.next = e;
		e.next = c;
		

		FindLoopBeginning flb = new FindLoopBeginning();
		ListNode loopBeginning = flb.findLoopBeginning(a);
		
				
		printNode(loopBeginning);
	}
}
	
	

