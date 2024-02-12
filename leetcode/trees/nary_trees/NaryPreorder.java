/*
589. N-ary Tree Preorder Traversal
Solved
Easy
Topics
Companies
Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
*/

class NaryPreorder {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for(Node n: root.children) preorder(n);
        return list;
    }
}