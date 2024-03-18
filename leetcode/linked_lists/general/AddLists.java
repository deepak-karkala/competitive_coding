/*
2. Add Two Numbers
Medium - 24.1K - 4.7K
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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

public class AddLists {

	/*
	Approach - baseline
		Iterate through each list, incrementing both by one at every step
		Add the digits in two lists and the carry
		If one of the lists hit end, just add digit from other list and carry
		When other lists also hits end, there could be one more node in output list with its val set of carry.
	*/
	private static ListNode addLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode n = head;
		int carry = 0, sum = 0, val = 0, l1val = 0, l2val = 0;

		while ( (l1 != null) || (l2 != null) ) {

			l1val = (l1 == null) ? 0 : l1.val;
			l2val = (l2 == null) ? 0 : l2.val;
			sum = (l1val + l2val + carry);
			val = sum % 10;
			carry = (sum >= 10) ? 1 : 0;

			n.next = new ListNode(val);
			n = n.next;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}

		if (carry == 1) n.next = new ListNode(carry);
		return head.next;
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
        int[] arr1 = {9,9,9,9,9,9,9};
        ListNode l1 = createSinglyLinkedList(arr1);
        int[] arr2 = {9, 9, 9, 9};
        ListNode l2 = createSinglyLinkedList(arr2);
        ListNode head = addLists(l1, l2);
        printLinkedList(head);
    }
}