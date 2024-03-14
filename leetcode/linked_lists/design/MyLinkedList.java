/*
707. Design Linked List
Solved
Medium
Topics
Companies
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
*/

class MyLinkedList {

    class Node {
        int val;
        Node next;
        public Node(int val) {this.val = val;}
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node curr = head;
        for(int i=0; i<index; i++) curr = curr.next;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
        return;
    }
    
    public void addAtTail(int val) {
        Node curr = head;
        Node node = new Node(val);
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            while(curr.next != null) curr = curr.next;
            curr.next = node;
        }
        size++;
        return;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        if (index == 0) { addAtHead(val); return; }
        if (index == size) {addAtTail(val); return; }

        Node curr = head;
        Node node = new Node(val);
        for(int i=0; i<index-1; i++) curr = curr.next;
        node.next = curr.next;
        curr.next = node;
        size++;
        return;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) { head = head.next; size--; return;}
        Node curr = head;
        for(int i=0; i<index-1; i++) curr = curr.next;
        curr.next = curr.next.next;
        size--;
        return;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */