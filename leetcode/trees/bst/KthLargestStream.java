/*
703. Kth Largest Element in a Stream
Easy
Topics
Companies
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
*/


class KthLargestStream {
    PriorityQueue<Integer> pq;
    int k; 

    public KthLargestHeap(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.k = k;
        for(int n: nums) addHeap(n);    
    }
    
    public int addHeap(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }


    class TreeNode {
        int val, count = 1;
        TreeNode left, right;
        TreeNode(int v) {val = v;}
    }
    TreeNode root;
    int k; 

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n: nums) root = add(root, n);    
    }
    
    public int add(int val) {
        root = add(root, val);
        return findKthLargest();
        // return findKthLargest(root, k);
    }

    public TreeNode add(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        root.count++;
        if (root.val > val) root.left = add(root.left, val);
        else root.right = add(root.right, val);
        return root;
    }

    public int findKthLargest() {
        TreeNode node = root;
        int count = k;

        while(count > 0) {
            int pos = 1 + (node.right != null ? node.right.count : 0);
            if (count == pos) return node.val;
            else if (count > pos) {
                count -= pos;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node.val;
    }

    public int findKthLargestRecursive(TreeNode node) {
        int pos = 1 + (node.right != null ? node.right.count : 0);

        if (pos == key) return node.val;
        else if (key > pos) return findKthLargestRecursive(node.left, key - pos);
        else return findKthLargestRecursive(node.right, pos);
    }

}