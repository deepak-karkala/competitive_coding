/*
*/

class PopulateNextPointersII {
    public Node connect(Node root) {
        if (root == null) return null;

        // Assign next of left
        if (root.left != null)
            if (root.right != null) root.left.next = root.right;
            else root.left.next = findNext(root);
        
        // Assign next of right
        if (root.right != null)
            root.right.next = findNext(root);
        
        // Recursively connect left and right subtrees
        connect(root.right);
        connect(root.left);
        return root;
    }

    public Node findNext(Node node) {
        while(node.next != null) {
            node = node.next;
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
        }
        return null;
    }
}