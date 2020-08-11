package linked_lists;
import java.util.HashMap;
/*
 * Write code to remove duplicates from an unsorted linked list.
 */

class Node {
	int val;
	Node next;
	
	Node (int val) {
		this.val = val;
	}
	
	Node (int val, Node next) {
		this.val = val;
		this.next = next;
	}
}

class LinkedList {
	Node head;
	
	LinkedList (Node n) {
		this.head = n;
	}
	
	LinkedList (int[] arr) {
		this.head = null;
		
		if (arr.length > 0) {
			Node n = new Node(arr[0]);
			this.head = n;
			
			for (int i=1; i<arr.length; i++) {
				n.next = new Node(arr[i]);
				n = n.next;
			}
		}
	}
	
	public void printList() {
		Node n = this.head;
		Node runner = n;
		while (runner.next != null) {
			System.out.print(n.val + "->");
			runner = n;
			n = n.next;
		}
		System.out.println("");
	}
	
	public LinkedList removeDuplicates () {
		Node n = this.head;
		Node runner = n;
		LinkedList list = new LinkedList(n);
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int key = 0;
		while (runner.next != null) {
			if (hmap.containsValue(n.val)) {
				runner.next = n.next;
			} else {
				hmap.put(key, n.val);
				runner = n;
			}
			n = n.next;
			key++;
		}
		return list;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(new int[] {3, 1, 5, 2, 1, 3, 6});
		list.printList();
		LinkedList uniqueList = list.removeDuplicates();
		uniqueList.printList();
		
	}
}