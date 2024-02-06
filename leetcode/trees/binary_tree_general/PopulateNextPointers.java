/*
116. Populating Next Right Pointers in Each Node
Solved
Medium
Topics
Companies
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
*/

class PopulateNextPointers {

	// BFS
	// Time: O(n) Space:O(2^n)
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                if (node == null) continue;
                node.next = prev;
                prev = node;
                q.offer(node.right);
                q.offer(node.left);
            }
        }
        return root;
    }


    // DFS
    // Time: O(logn) Space:O(1) excluding recursion
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private static void dfs(Node curr, Node next) {
        if (curr == null) return;
        curr.next = next;

        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
        return;
    }
}