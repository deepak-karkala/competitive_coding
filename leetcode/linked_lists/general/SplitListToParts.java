/*
725. Split Linked List in Parts
Solved
Medium
Topics
Companies
Hint
Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.
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

class SplitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] nodes = new ListNode[k];
        ListNode node = head, prev=null;

        int len = 0;
        while(node != null) {node = node.next; len++;}

        int minLen = len/k;
        int nSplitsWithExtra = len % k;

        node = head;
        for(int i=0; i<k && node != null; i++) {
            nodes[i] = node;

            int currSplitLen = minLen + (i < nSplitsWithExtra ? 1: 0);
            //int currSplitLen = minLen + (nSplitsWithExtra > 0 ? 1: 0);
            for(int j=0; j<currSplitLen; j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return nodes;
    }

}