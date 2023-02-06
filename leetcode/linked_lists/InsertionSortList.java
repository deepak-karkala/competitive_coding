/*
147. Insertion Sort List
Medium
2.5K
830
Given the head of a singly linked list, sort the list using
insertion sort, and return the sorted list's head.
*/

class ListNode {
    int val;
    ListNode next, prev;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}



public class InsertionSortList {

	private static ListNode insertionSortList(ListNode head) {

		ListNode curr = head.next;
		while(curr != null){
			ListNode next = curr.next;
			ListNode ptr = head, prev = head;
			int i = 0;
			while((curr.val >= ptr.val) && (ptr.next != curr)){
				prev = ptr;
				ptr = ptr.next;
				i++;
			}
			if (ptr != curr) {
				prev.next = curr;
				curr.next = ptr;
				//ptr.next = next;
				while(ptr.next != curr) {
					System.out.println(ptr.val);
					System.out.println(curr.val);
					ptr = ptr.next;
				}
				ptr.next = next;
			}
			curr = next;
		}
		return head;
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

    public static void main(String[] args) {
        int[] arr = {2, 3};
        ListNode list = createSinglyLinkedList(arr);
        ListNode head = insertionSortList(list);
        printLinkedList(head);
    }

}