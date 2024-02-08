/*
701. Insert into a Binary Search Tree
Solved
Medium
Topics
Companies
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
*/

class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        if (root == null) {root = new TreeNode(val); return root;}

        while(node != null) {
            if (node.val > val) {
                if (node.left == null) { node.left = new TreeNode(val); return root;}
                else node = node.left;
            } else {
                if (node.right == null) { node.right = new TreeNode(val); return root;}
                else node = node.right;
            }
        }
        return root;
    }

    public TreeNode insertIntoBSTRecursive(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val > val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
}