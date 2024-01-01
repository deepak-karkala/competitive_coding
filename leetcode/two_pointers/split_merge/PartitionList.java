/*
86. Partition List
Solved
Medium
Topics
Companies
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions
*/


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class PartitionList {
	/*
	Approach: Two pointers, split and merge
	Time: O(n)	Space: O(1)
	*/
    private static ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(Integer.MIN_VALUE), bigHead = new ListNode(Integer.MIN_VALUE);
        ListNode smallRunner = smallHead, bigRunner = bigHead;

        while (head != null) {
        	if (head.val < x) {
        		smallRunner.next = head;
        		smallRunner = smallRunner.next;
        	} else {
        		bigRunner.next = head;
        		bigRunner = bigRunner.next;
        	}
        	head = head.next;
        }

        smallRunner.next = bigHead.next;
        bigRunner.next = null;
        return smallHead.next;
    }

    public static void main(String[] args) {
    	ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))  ));
    	int x = 3;
    	ListNode split = partition(head, x);
    	while(split != null) {
    		System.out.print(split.val + "-->");
    		split = split.next;
    	}
    }
}