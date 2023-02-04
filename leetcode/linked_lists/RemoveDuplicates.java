import java.util.HashSet;

class LlNode{
    int data;
    LlNode next, prev;
    LlNode() {};
    LlNode(int data) {this.data = data;}
    LlNode(int data, LlNode next) {
        this.data = data; this.next = next;
    }
}


public class RemoveDuplicates {

    private static LlNode createLinkedList(int[] arr) {
        LlNode head = null, next = null, prev = null;
        
        for(int i=0; i<arr.length; i++) {
            LlNode n = new LlNode(arr[i], next);
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

    private static LlNode removeDuplicatesSet(LlNode head) {
        HashSet<Integer> set = new HashSet<Integer>();
        LlNode n = head, prev = null;
        while(n != null) {
            if (!set.contains(n.data)) {
                set.add(n.data);
                prev = n;
            } else {
                prev.next = n.next;
            }
            n = n.next;
        }
        return head;
    }

    private static LlNode removeDuplicates(LlNode head) {
        if ((head==null) || (head.next==null)) return head;

        LlNode n = head, prev = head;
        while (n != null) {
            if (n.data != prev.data) {
                prev = n;
            } else {
                prev.next = n.next;
            }
            n = n.next;
        }
        return head;
    }


    private static LlNode removeDuplicatesRecursive(LlNode head) {
        if ((head==null) || (head.next==null)) return head;

        head.next = removeDuplicatesRecursive(head.next);
        return head.data == head.next.data ? head.next : head;
    }



    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4};
        LlNode head = createLinkedList(arr);
        printLinkedList(head);
        head = removeDuplicatesRecursive(head);
        printLinkedList(head);
    }
}
