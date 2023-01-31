package linked_lists;

import java.util.HashSet;

class LlNode{
    int data;
    LlNode next, prev;
    LlNode() {};
    LlNode(int data) {this.data = data;}
    LlNode(int data, LlNode next, LlNode prev) {
        this.data = data; this.next = next; this.prev = prev;
    }
}


public class DoublyLinkedList {

    private static LlNode createLinkedList(int[] arr) {
        LlNode head = null, next = null, prev = null;
        
        for(int i=0; i<arr.length; i++) {
            LlNode n = new LlNode(arr[i], next, prev);
            if (i!=0) {
                prev.next = n;
            } else {
                head = n;
            }
            prev = n;
        }
        
        return head;
    }

    private static void printLinkedList(LlNode head) {
        LlNode ptr = head;
        while(ptr != null) {
            System.out.print(ptr.data + "-->");
            ptr = ptr.next;
        }
        System.out.println("");
    }

    private static LlNode removeDuplicates(LlNode head) {
        HashSet<Integer> set = new HashSet<Integer>();
        LlNode n = head;
        while(n != null) {
            if (!set.contains(n.data)) {
                set.add(n.data);
            } else {
                if (n.prev != null) n.prev.next = n.next;
                if (n.next != null) n.next.prev = n.prev;
            }
            n = n.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        LlNode head = createLinkedList(arr);
        printLinkedList(head);
        head = removeDuplicates(head);
        printLinkedList(head);
    }
}
