/*
23. Merge k Sorted Lists
Solved
Hard
Topics
Companies
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
*/

class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        //PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    	ListNode ptr = new ListNode();
        ListNode init = new ListNode();
        ListNode list = init;

        for(int i=0; i<lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(new int[]{i, lists[i].val});
                lists[i] = lists[i].next;
            }
        }

        while(!pq.isEmpty()) {
            int[] smallest = pq.poll();

            list.next = new ListNode(smallest[1]);
            list = list.next;

            int listId = smallest[0];
            if (lists[listId] != null) {
                pq.offer(new int[]{listId, lists[listId].val});
                lists[listId] = lists[listId].next;
            }
        }
        return init.next;
    }
}