/*
429. N-ary Tree Level Order Traversal
Solved
Medium
Topics
Companies
Given an n-ary tree, return the level order traversal of its nodes' values.
*/

class NaryLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) return lists;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                list.add(node.val);
                for(Node n: node.children) if (n != null) q.offer(n);
            }
            lists.add(new ArrayList<>(list));
        }
        return lists;
    }
}