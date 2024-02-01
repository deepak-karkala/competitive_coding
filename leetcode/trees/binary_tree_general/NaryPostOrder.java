/*
590. N-ary Tree Postorder Traversal
Solved
Easy
Topics
Companies
Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
*/

class NaryPostOrder {
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> postorderRecursive(Node root) {
        if (root == null) return list;
        for(Node n: root.children)
            postorder(n);
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderIterative(Node root) {
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(0, node.val);
            for(Node n: node.children) stack.push(n);
        }
        return list;
    }
}