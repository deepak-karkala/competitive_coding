/*
237. Delete Node in a Linked List
Medium
Topics
Companies
There is a singly-linked list head and we want to delete a node node in it.

You are given the node to be deleted node. You will not be given access to the first node of head.

All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
*/

class DeleteNode {
    // Time:O(1)
    // Overwrite current node's value with next node's value
    // Set next of current node to next.next
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}