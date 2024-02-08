/*
450. Delete Node in a BST
Solved
Medium
Topics
Companies
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST
*/

class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // Delete this node
            // If one of left or right subtrees is null, replace with other
            if (root.left == null) return root.right;
            if (root.right== null) return root.left;

            // If both subtrees are not null, 
            //      replace with successor (leftmost of right subtree)
            TreeNode successor = root.right;
            while(successor.left != null) successor = successor.left;
            successor.left = root.left;
            return root.right;
        }
        return root;
    }
}