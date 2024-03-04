/*
1171. Remove Zero Sum Consecutive Nodes from Linked List
Solved
Medium
Topics
Companies
Hint
Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.
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

class RemoveZeroSumSublists {
    /*
        Iterate for the first time, calculate the prefix sum,
        Save it in hashmap<sum, node>.
        If there is a sequence with sum=0 in between,
            hashmap<sum, seq_start_node> will be overwritten
            with hashmap<sum, seq_end_node
        Iterate for the second time, when we calculate prefix sum, when we
            come across that sum, we know the sequence end
            and can jump there, skipping the in between nodes 
         calculate the prefix sum,
    */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);

        int prefixSum = 0;
        while(head != null) {
            prefixSum += head.val;
            map.put(prefixSum, head);
            head = head.next;
        }

        head = dummy;
        prefixSum = 0;
        while(head != null) {
            prefixSum += head.val;
            ListNode zeroSeqEnd = map.get(prefixSum);

            if (zeroSeqEnd != head) head.next = zeroSeqEnd.next;
            head = head.next;
        }
        return dummy.next;
    }
}